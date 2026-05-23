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

    public ClienteModelo buscarClientePorId(String id){
        return clienteRepository.findById(id).get();
    }

    public ClienteModelo AgregarCliente(ClienteModelo cliente) {
        return clienteRepository.save(cliente);
    }
    public void borrarCliente(String id) {
        clienteRepository.deleteById(id);
    }
    public ClienteModelo buscarClientePorIdUsuario(String idUsuario){
        return clienteRepository.findByidUsuario(idUsuario);
    }
    public ClienteModelo actualizarCliente(ClienteModelo cliente) {

        return clienteRepository.save(cliente);
    }



}
