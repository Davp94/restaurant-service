package com.blumbit.restaurant_service.dto.request;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileRequest {

    private String title;

    @NotNull(message = "validation.general.not_null")
    private MultipartFile file;
}
