package com.blumbit.restaurant_service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.blumbit.restaurant_service.entity.Pedido;

public interface PedidoPageableRepository extends ListPagingAndSortingRepository<Pedido, Integer>{

    Page<Pedido> findByCliente_NombreContainingIgnoreCase(String nombre, Pageable pageable);

}
