package com.blumbit.restaurant_service.service;

import java.util.List;

import com.blumbit.restaurant_service.dto.request.PedidoRequestDto;
import com.blumbit.restaurant_service.dto.response.PedidoResponseDto;

public interface IPedidoService {

    String createPedido(PedidoRequestDto pedidoRequestDto);

    List<PedidoResponseDto> pedidos();
}
