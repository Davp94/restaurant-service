package com.blumbit.restaurant_service.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.blumbit.restaurant_service.entity.Pedido;

public interface PedidoRepository extends ListCrudRepository<Pedido, Integer> {

}
