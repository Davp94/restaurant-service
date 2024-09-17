package com.blumbit.restaurant_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.blumbit.restaurant_service.dto.request.ClienteRequestDto;
import com.blumbit.restaurant_service.dto.response.ClienteResponseDto;
import com.blumbit.restaurant_service.service.IClienteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("clientes")
public class ClienteController {

    private  IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping()
    public List<ClienteResponseDto> findAllClientes(){
        return clienteService.findAllClientes();
    }

    @PostMapping()
    public ClienteResponseDto createCliente(@RequestBody @Valid ClienteRequestDto ClienteRequestDto){
        return clienteService.createCliente(ClienteRequestDto);
    }
}
