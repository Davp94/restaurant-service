package com.blumbit.restaurant_service.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.blumbit.restaurant_service.entity.Menu;

public interface MenuRepository extends ListCrudRepository<Menu, Integer>{

    Menu findByIdAndActive(Short id, Boolean active);

}
