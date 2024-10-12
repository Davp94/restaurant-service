package com.blumbit.restaurant_service.service;

import java.util.List;

import com.blumbit.restaurant_service.dto.response.MenuResponseDto;
import com.blumbit.restaurant_service.dto.response.PlatoResponseDto;

public interface IMenuService {

    List<MenuResponseDto> findAllByMenuId(List<Short> menusId);

    List<PlatoResponseDto> findAllPlatos();

}
