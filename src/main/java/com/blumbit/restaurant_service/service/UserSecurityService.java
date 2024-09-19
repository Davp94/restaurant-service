package com.blumbit.restaurant_service.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blumbit.restaurant_service.entity.Cliente;
import com.blumbit.restaurant_service.repository.ClienteRepository;

@Service
public class UserSecurityService implements UserDetailsService{

    private final ClienteRepository clientRepository;


    public UserSecurityService(ClienteRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente cliente = clientRepository.findOneByCorreo(username).orElseThrow(() -> new UsernameNotFoundException("usuario no encontrado"));
        return User.builder()
                    .username(cliente.getCorreo())
                    .password(cliente.getPassword())
                    .build();
    }

}
