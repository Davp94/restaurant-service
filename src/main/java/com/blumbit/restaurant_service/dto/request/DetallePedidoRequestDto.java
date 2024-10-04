package com.blumbit.restaurant_service.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetallePedidoRequestDto {

    private Short cantidad;

    private Short subTotal;

    private Integer platoId;
}
