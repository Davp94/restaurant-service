package com.blumbit.restaurant_service.dto.response;

import java.math.BigDecimal;

import com.blumbit.restaurant_service.entity.Plato;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlatoResponseDto {

    private Integer id;

    private String nombre;

    private String descripcion;

    private BigDecimal precio;

    private String image;

    private Short menuId;

    public static PlatoResponseDto fromEntity(Plato plato){
        return PlatoResponseDto.builder()
                .id(plato.getId())
                .nombre(plato.getNombre())
                .descripcion(plato.getDescripcion())
                .image(plato.getImage())
                .menuId(plato.getMenu().getId())
                .precio(plato.getPrecio())
                .build();
    }

}
