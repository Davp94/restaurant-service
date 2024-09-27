package com.blumbit.restaurant_service.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blumbit.restaurant_service.common.MessageUtil;
import com.blumbit.restaurant_service.dto.request.ClienteRequestDto;
import com.blumbit.restaurant_service.dto.response.ClienteResponseDto;
import com.blumbit.restaurant_service.entity.Cliente;
import com.blumbit.restaurant_service.exception.EmptyListException;
import com.blumbit.restaurant_service.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService{

    private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

    private final ClienteRepository clienteRepository;

    private final PasswordEncoder passwordEncoder;

    private final MessageUtil messageUtil;

    public ClienteServiceImpl(ClienteRepository clienteRepository, MessageUtil messageUtil, PasswordEncoder passwordEncoder) {
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
        this.messageUtil = messageUtil;
    }

    @Override
    public List<ClienteResponseDto> findAllClientes() {
        List<Cliente> clientes;
        try {
            clientes = clienteRepository.findAll();
            if(clientes.size() == 0){
                throw new EmptyListException(messageUtil.getMessage("message.list.empty"));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(messageUtil.getMessage("error.bad_request"));
        }
        return clientes.stream().map(ClienteResponseDto::buildFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDto createCliente(ClienteRequestDto clienteRequestDto) {
        try {
            Cliente clienteToCreate = ClienteRequestDto.buildToEntity(clienteRequestDto);
            clienteToCreate.setPassword(passwordEncoder.encode(clienteToCreate.getPassword()));
            Cliente cliente = clienteRepository.save(clienteToCreate);
            return ClienteResponseDto.buildFromEntity(cliente);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

}
