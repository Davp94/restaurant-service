package com.blumbit.restaurant_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.restaurant_service.common.CommonResponse;
import com.blumbit.restaurant_service.dto.request.MenuRequestDto;
import com.blumbit.restaurant_service.dto.response.MenuResponseDto;
import com.blumbit.restaurant_service.dto.response.PlatoResponseDto;
import com.blumbit.restaurant_service.service.IMenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final IMenuService menuService;

    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping()
    public CommonResponse<List<MenuResponseDto>> findAllMenus(@RequestParam List<Short> ids){
        return CommonResponse.success(menuService.findAllByMenuId(ids), "operacion ejecutada exitosamente") ;
    }

    @GetMapping("/platos")
    public CommonResponse<List<PlatoResponseDto>> findAllPlatos(){
        return CommonResponse.success(menuService.findAllPlatos(), "operacion ejecutada exitosamente") ;
    }

}
