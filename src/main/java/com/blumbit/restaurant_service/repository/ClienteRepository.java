package com.blumbit.restaurant_service.repository;

import org.springframework.data.repository.ListCrudRepository;
import com.blumbit.restaurant_service.entity.Cliente;

public interface ClienteRepository extends ListCrudRepository<Cliente, Integer> {

}
