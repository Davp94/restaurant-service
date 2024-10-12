package com.blumbit.restaurant_service.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.blumbit.restaurant_service.dto.request.PagePedidoRequestDto;
import com.blumbit.restaurant_service.dto.request.PedidoRequestDto;
import com.blumbit.restaurant_service.dto.response.CreatePedidoResponseDto;
import com.blumbit.restaurant_service.dto.response.PedidoResponseDto;
import com.blumbit.restaurant_service.entity.Pedido;

public interface IPedidoService {

    CreatePedidoResponseDto createPedido(PedidoRequestDto pedidoRequestDto);

    List<PedidoResponseDto> pedidos();

    Page<Pedido> findByNombreContainingIgnoreCase(PagePedidoRequestDto pedidoRequestDto);
}
