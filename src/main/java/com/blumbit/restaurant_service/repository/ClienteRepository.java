package com.blumbit.restaurant_service.repository;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import com.blumbit.restaurant_service.entity.Cliente;


public interface ClienteRepository extends ListCrudRepository<Cliente, Integer> {

    Optional<Cliente> findOneByCorreo(String correo);

}
