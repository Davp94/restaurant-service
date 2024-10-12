package com.blumbit.restaurant_service.dto.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuRequestDto {

    private List<Short> ids;

}
