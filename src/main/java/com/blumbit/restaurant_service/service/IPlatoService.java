package com.blumbit.restaurant_service.service;

import java.util.List;

import com.blumbit.restaurant_service.dto.response.PlatoResponseDto;

public interface IPlatoService {

    List<PlatoResponseDto> findAllPlatoByMenuId(Short menuId);
}
