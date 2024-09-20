package com.blumbit.restaurant_service.utils;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blumbit.restaurant_service.entity.Cliente;
import com.blumbit.restaurant_service.repository.ClienteRepository;

@Component
public class SeedInitialData implements CommandLineRunner{

    private final ClienteRepository clienteRepository;

    public SeedInitialData(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        Cliente cliente = new Cliente();
        cliente.setNombre("test");
        cliente.setApellidos("test");
        cliente.setCorreo("test@test.com");
        cliente.setEnable(true);
        cliente.setIdentifier("00001");
        cliente.setNit("123456");
        cliente.setRazonSocial("Test SA");
        cliente.setPassword("$2a$12$Z7KBbRgwdXYx/NG4jc1/FetEk3Xg7lD44Lp5FV/LZl37xHPqWjSdC");

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("test2");
        cliente2.setApellidos("test2");
        cliente2.setCorreo("test@test2.com");
        cliente2.setEnable(true);
        cliente2.setIdentifier("00002");
        cliente2.setNit("654321");
        cliente2.setRazonSocial("Test2 SA");
        cliente2.setPassword("$2a$12$Z7KBbRgwdXYx/NG4jc1/FetEk3Xg7lD44Lp5FV/LZl37xHPqWjSdC");

        clienteRepository.saveAll(List.of(cliente, cliente2));
    }

}
