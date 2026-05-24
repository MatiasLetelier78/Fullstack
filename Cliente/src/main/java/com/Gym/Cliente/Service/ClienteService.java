package com.Gym.Cliente.Service;

import com.Gym.Cliente.Modelo.ClienteModelo;
import com.Gym.Cliente.Repository.ClienteRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModelo> listarClientes(){
        return clienteRepository.findAll();
    }

    public ClienteModelo buscarClientePorId(String idUsuario){
        return clienteRepository.findById(idUsuario).get();
    }

    public ClienteModelo agregarCliente(ClienteModelo cliente) {
        return clienteRepository.save(cliente);
    }

    public ClienteModelo buscarClientePorIdUsuario(String idUsuario){
        return clienteRepository.findByidUsuario(idUsuario);
    }
    public boolean borrarCliente(String idUsuario) {
        ClienteModelo cliente = buscarClientePorIdUsuario(idUsuario);
        if(cliente != null){
            clienteRepository.deleteById(idUsuario);
            return true;
        }else{
            return false;
        }
    }
    public ClienteModelo actualizarCliente(ClienteModelo cliente) {
        return clienteRepository.save(cliente);
    }



}
