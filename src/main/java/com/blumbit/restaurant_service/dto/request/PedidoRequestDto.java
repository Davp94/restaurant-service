package com.blumbit.restaurant_service.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDto {
    private Integer clienteId;

    private List<DetallePedidoRequestDto> detallesPedido;
}
