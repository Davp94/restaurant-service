package com.blumbit.restaurant_service.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuResponseDto {

    private Short id;

    private String nombre;

    private List<PlatoResponseDto> platos;
}
