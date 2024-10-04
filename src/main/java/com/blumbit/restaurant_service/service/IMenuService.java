package com.blumbit.restaurant_service.service;

import java.util.List;

import com.blumbit.restaurant_service.dto.response.MenuResponseDto;

public interface IMenuService {

    List<MenuResponseDto> findAllByMenuId(Short menuId);
}
