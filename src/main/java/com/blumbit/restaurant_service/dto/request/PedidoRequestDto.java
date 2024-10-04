package com.blumbit.restaurant_service.dto.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoRequestDto {
    private Integer clienteId;

    private List<DetallePedidoRequestDto> detallesPedido;
}
