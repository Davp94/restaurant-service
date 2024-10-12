package com.blumbit.restaurant_service.dto.response;

import com.blumbit.restaurant_service.entity.DetallePedido;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class DetallePedidoResponseDto {
    private Integer id;

    private Short cantidad;

    private Short subTotal;

    private PlatoResponseDto plato;

    public static DetallePedidoResponseDto fromEntity(DetallePedido pedido){
        return DetallePedidoResponseDto.builder()
                .id(pedido.getId())
                .cantidad(pedido.getCantidad())
                .plato(PlatoResponseDto.fromEntity(pedido.getPlato()))
                .subTotal(pedido.getSubTotal())
                .build();
    }
}
