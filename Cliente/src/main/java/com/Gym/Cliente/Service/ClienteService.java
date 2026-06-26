package com.Gym.Cliente.Service;

import com.Gym.Cliente.Modelo.ClienteModelo;
import com.Gym.Cliente.Repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModelo> listarClientes(){
        log.info("Iniciando listado de clientes");
        return clienteRepository.findAll();
    }

    public ClienteModelo buscarClientePorId(String id){
        try {
            log.info("Iniciando búsqueda de cliente por id {}", id);
            return clienteRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("Error al buscar cliente por id {}: {}", id, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public ClienteModelo agregarCliente(ClienteModelo cliente) {
        try {
            if (clienteRepository.existsById(cliente.getIdUsuario())) {
                log.warn("Cliente ya existe con idUsuario {}", cliente.getIdUsuario());
                return null;
            } else {
                log.info("Registrando cliente con idUsuario {}", cliente.getIdUsuario());
                return clienteRepository.save(cliente);
            }
        } catch (Exception e) {
            log.error("Error al agregar cliente: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public ClienteModelo buscarClientePorIdUsuario(String idUsuario){
        try {
            log.info("Iniciando búsqueda de cliente por idUsuario {}", idUsuario);
            return clienteRepository.findByidUsuario(idUsuario);
        } catch (Exception e) {
            log.error("Error al buscar cliente por idUsuario {}: {}", idUsuario, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public boolean borrarCliente(String idUsuario) {
        try {
            ClienteModelo cliente = buscarClientePorIdUsuario(idUsuario);

            if(cliente != null){
                log.info("Eliminando cliente con idUsuario {}", idUsuario);
                clienteRepository.deleteById(idUsuario);
                return true;
            }else{
                log.warn("No se encontró cliente con idUsuario {}", idUsuario);
                return false;
            }
        } catch (Exception e) {
            log.error("Error al borrar cliente: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public ClienteModelo actualizarCliente(ClienteModelo cliente) {
        try {
            ClienteModelo clienteExistente = clienteRepository.findById(cliente.getIdUsuario()).orElse(null);

            if (clienteExistente != null) {
                log.info("Actualizando cliente con idUsuario {}", cliente.getIdUsuario());
                return clienteRepository.save(cliente);
            } else {
                log.warn("No se encontró cliente con idUsuario {}", cliente.getIdUsuario());
                return null;
            }
        } catch (Exception e) {
            log.error("Error al actualizar cliente: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
