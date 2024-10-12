package com.blumbit.restaurant_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.restaurant_service.common.CommonResponse;
import com.blumbit.restaurant_service.dto.request.PagePedidoRequestDto;
import com.blumbit.restaurant_service.dto.request.PedidoRequestDto;
import com.blumbit.restaurant_service.dto.response.CreatePedidoResponseDto;
import com.blumbit.restaurant_service.entity.Pedido;
import com.blumbit.restaurant_service.service.IPedidoService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("pedido")
public class PedidoController {

    private final IPedidoService pedidoService;

    public PedidoController(IPedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping()
    public CommonResponse<CreatePedidoResponseDto> createPedido(@RequestBody @Valid PedidoRequestDto pedidoRequestDto){
        System.out.println(pedidoRequestDto);
        return CommonResponse.success(pedidoService.createPedido(pedidoRequestDto), "Operacion realizada exitosamente");
    }
    
    @GetMapping()
    public CommonResponse<Page<Pedido>> getPedidosPaginated(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String sortParam, @RequestParam Integer order, @RequestParam String nombre) {
        return CommonResponse.success(pedidoService.findByNombreContainingIgnoreCase(new PagePedidoRequestDto(page, size, sortParam, order, nombre)), "Operacion realizada exitosamente");
    }
    



}
