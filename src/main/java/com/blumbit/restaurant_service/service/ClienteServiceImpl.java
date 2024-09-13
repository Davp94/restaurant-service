package com.blumbit.restaurant_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blumbit.restaurant_service.dto.request.ClienteRequestDto;
import com.blumbit.restaurant_service.dto.response.ClienteResponseDto;
import com.blumbit.restaurant_service.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService{

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteResponseDto> findAllClientes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllClientes'");
    }

    @Override
    public ClienteResponseDto createCliente(ClienteRequestDto ClienteRequestDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCliente'");
    }

}
