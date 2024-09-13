package com.blumbit.restaurant_service.service;

import java.util.List;

import com.blumbit.restaurant_service.dto.request.ClienteRequestDto;
import com.blumbit.restaurant_service.dto.response.ClienteResponseDto;

public interface IClienteService {

    public List<ClienteResponseDto> findAllClientes();

    public ClienteResponseDto createCliente(ClienteRequestDto ClienteRequestDto);

}
