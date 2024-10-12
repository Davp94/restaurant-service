package com.blumbit.restaurant_service.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePedidoResponseDto {
    private Integer pedidoId;
    private Short total;
    private LocalDateTime fecha;
}
