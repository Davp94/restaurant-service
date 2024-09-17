package com.blumbit.restaurant_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cliente {

    @Id
    @Column(name = "cli_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(unique = true)
    private String identifier;

    private String nombre;

    @Column(nullable = false, length = 100, name = "cli_apellidos")
    private String apellidos;

    private String correo;

    private String razonSocial;

    private boolean enable;

    @Column(nullable = false, unique = true)
    private String nit;

    private String password;

}
