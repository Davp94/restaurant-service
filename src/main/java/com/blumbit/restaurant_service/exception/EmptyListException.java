package com.blumbit.restaurant_service.exception;

public class EmptyListException extends RuntimeException{

    public EmptyListException(String message){
        super(message);
    }

}
