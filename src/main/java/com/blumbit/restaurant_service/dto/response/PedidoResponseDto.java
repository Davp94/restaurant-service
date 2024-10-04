package com.blumbit.restaurant_service.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoResponseDto {

    private Integer id;

    private ClienteResponseDto clienteResponseDto;

    private LocalDateTime fecha;

    private Short total;

    private List<DetallePedidoResponseDto> detallesPedido;
}
