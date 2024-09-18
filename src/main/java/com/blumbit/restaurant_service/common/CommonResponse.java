package com.blumbit.restaurant_service.common;

import org.springframework.http.HttpStatus;

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
public class CommonResponse<T> {
    private HttpStatus statusCode;
    private String message;
    private T data;

    public static <T> CommonResponse<T> success(T data, String message){
        return CommonResponse.<T>builder()
            .statusCode(HttpStatus.ACCEPTED)
            .message(message)
            .data(data)
            .build();
    }
}
