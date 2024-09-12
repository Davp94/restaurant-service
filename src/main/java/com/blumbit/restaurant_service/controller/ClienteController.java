package com.blumbit.restaurant_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.restaurant_service.entity.Cliente;
import com.blumbit.restaurant_service.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("clientes")
    public List<Cliente> findAllClientes(){
        return clienteRepository.findAll();
    }

    @PostMapping("clientes")
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

}
