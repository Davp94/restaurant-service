package com.blumbit.restaurant_service.dto.request;

import com.blumbit.restaurant_service.entity.Cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteRequestDto {

    @NotNull(message = "No se permiten valores nulos")
    @NotEmpty(message = "No se permiten valores nulos")
    @Size(min = 3, message = "Debe tener una longitud mayor a 3 caracteres")
    private String nombre;

    @NotNull(message = "No se permiten valores nulos")
    @NotEmpty(message = "No se permiten valores nulos")
    @Size(min = 5, max = 20)
    private String apellidos;

    @Email()
    private String correo;

    @NotNull(message = "No se permiten valores nulos")
    @NotEmpty(message = "No se permiten valores nulos")
    private String nit;

    @NotNull(message = "No se permiten valores nulos")
    @NotEmpty(message = "No se permiten valores nulos")
    private String razonSocial;

    @NotNull(message = "No se permiten valores nulos")
    @NotEmpty(message = "No se permiten valores nulos")
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{6,20})", message = "El password debe tener minimo 8 caracteres, mayusculas minusculas y al menos un numero y un caracter especial.")
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
