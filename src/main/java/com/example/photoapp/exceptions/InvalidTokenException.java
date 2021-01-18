package com.example.photoapp.exceptions;

public class InvalidTokenException extends Exception {

    @Override
    public String getMessage(){
        return "Invalid Token";
    }

}
