package com.blumbit.restaurant_service.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.restaurant_service.dto.request.LoginRequestDto;
import com.blumbit.restaurant_service.dto.response.LoginResponseDto;
import com.blumbit.restaurant_service.utils.JWTUtil;


@RestController
@RequestMapping("/user")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JWTUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        System.out.println("-----------------------------------------------------");
        System.out.println(loginRequestDto);
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(login);
        String jwt = jwtUtil.createToken(loginRequestDto.getUsername());
        return new LoginResponseDto(jwt);
    }


}
