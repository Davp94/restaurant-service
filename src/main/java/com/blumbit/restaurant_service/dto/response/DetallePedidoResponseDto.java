package com.blumbit.restaurant_service.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetallePedidoResponseDto {
    private Integer id;

    private Short cantidad;

    private Short subTotal;

    private PlatoResponseDto plato;
}
