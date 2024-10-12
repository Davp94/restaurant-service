package com.blumbit.restaurant_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PagePedidoRequestDto {

    private Integer page;
    
    private Integer size;

    private String sortParam;

    private Integer order;

    private String nombre;

}
