package com.blumbit.restaurant_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blumbit.restaurant_service.dto.response.MenuResponseDto;
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
            List<Plato> platosRetrieved = platoRepository.findByMenu_Id(menuId);
            MenuResponseDto menuResponse = new MenuResponseDto();
            menuResponse.setId(menuRetrieved.getId());
            menuResponse.setNombre(menuRetrieved.getNombre());
            // TODO add platos builder method on dto
            // menuResponse.setPlatos(platosRetrieved);
            menus.add(menuResponse);
        }
        return menus;
    }

}
