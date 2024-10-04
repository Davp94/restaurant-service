package com.blumbit.restaurant_service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.blumbit.restaurant_service.entity.Plato;
import java.util.List;


public interface PlatoRepository extends ListCrudRepository<Plato, Integer>{

    //Query methods
    List<Plato> findByMenu_Id(Short menuId);

    //native query (sql)
    @Query(value = "select * from plato p where menu_id = :menuId", nativeQuery = true)
    List<Plato> listadoDePlatosPorMenuId(Short menuId);

    // //jpql query
    // @Query(value = "select plato from Plato p where p.menuId = :menuId")
    // List<Plato> listadoDePlatosPorMenuIdJpql(Short menuId);

}
