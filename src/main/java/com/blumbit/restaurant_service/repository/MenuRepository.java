package com.blumbit.restaurant_service.repository;

import java.util.List;

import com.blumbit.restaurant_service.entity.Menu;

public interface MenuRepository {

    Menu findByIdAndActive(Short id, Boolean active);

}
