package com.blumbit.restaurant_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blumbit.restaurant_service.dto.response.MenuResponseDto;
import com.blumbit.restaurant_service.dto.response.PlatoResponseDto;
import com.blumbit.restaurant_service.entity.Menu;
import com.blumbit.restaurant_service.entity.Plato;
import com.blumbit.restaurant_service.repository.MenuRepository;
import com.blumbit.restaurant_service.repository.PlatoRepository;

@Service
public class MenuServiceImpl implements IMenuService {

    private final MenuRepository menuRepository;

    private final PlatoRepository platoRepository;

    public MenuServiceImpl(MenuRepository menuRepository, PlatoRepository platoRepository) {
        this.menuRepository = menuRepository;
        this.platoRepository = platoRepository;
    }

    @Override
    public List<MenuResponseDto> findAllByMenuId(List<Short> menusIds) {
        List<MenuResponseDto> menus = new ArrayList<>();
        for (Short menuId : menusIds) {
            Menu menuRetrieved = menuRepository.findByIdAndActive(menuId, true);
            MenuResponseDto menuResponse = new MenuResponseDto();
            menuResponse.setId(menuRetrieved.getId());
            menuResponse.setNombre(menuRetrieved.getNombre());
            menuResponse.setDescripcion(menuRetrieved.getDescripcion());
            menus.add(menuResponse);
        }
        return menus;
    }

    @Override
    public List<PlatoResponseDto> findAllPlatos() {
        List<PlatoResponseDto> platos = new ArrayList<>();
        List<Plato> platosRetrieved = platoRepository.findAll();
        for (Plato plato : platosRetrieved) {
            PlatoResponseDto platoResponse = new PlatoResponseDto();
            platoResponse.setId(plato.getId());
            platoResponse.setDescripcion(plato.getDescripcion());
            platoResponse.setNombre(plato.getNombre());
            platoResponse.setPrecio(plato.getPrecio());
            platoResponse.setImage(plato.getImage());
            platoResponse.setMenuId(plato.getMenu().getId());
            platos.add(platoResponse);
        }
        return platos;
    }

}
