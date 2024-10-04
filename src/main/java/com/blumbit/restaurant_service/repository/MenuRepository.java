package com.blumbit.restaurant_service.repository;

import java.util.List;

import com.blumbit.restaurant_service.entity.Menu;

public interface MenuRepository {

    List<Menu> findByActive(Boolean active);

}
