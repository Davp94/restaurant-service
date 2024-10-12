package com.blumbit.restaurant_service.dto.request;

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
public class DetallePedidoRequestDto {

    private Short cantidad;

    private Short subTotal;

    private Integer platoId;
}
