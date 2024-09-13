package com.blumbit.restaurant_service.dto.request;

import com.blumbit.restaurant_service.dto.response.clienteRequestDto;
import com.blumbit.restaurant_service.entity.Cliente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteRequestDto {

    private String nombre;

    private String apellidos;

    private String correo;

    private String nit;

    private String razonSocial;

    private String password;

    public static Cliente buildToEntity(ClienteRequestDto clienteRequestDto) {
        return Cliente.builder()
                .nombre(clienteRequestDto.getNombre())
                .apellidos(clienteRequestDto.getApellidos())
                .correo(clienteRequestDto.getCorreo())
                .nit(clienteRequestDto.getNit())
                .razonSocial(clienteRequestDto.getRazonSocial())
                .password(clienteRequestDto.getPassword())
                .build();
    }
}
