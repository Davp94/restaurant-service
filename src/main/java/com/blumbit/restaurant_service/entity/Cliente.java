package com.blumbit.restaurant_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @Column(name = "cli_id")
    private Integer id;

    private String nombre;

    @Column(nullable = false, length = 100, name = "cli_apellidos")
    private String apellidos;

    private String correo;

    private String razonSocial;

    @Column(nullable = false, unique = true)
    private String nit;

    private String password;

}
