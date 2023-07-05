package com.bigproject.movieproject.Exception;

public class UserAlreadyExistException  extends RuntimeException{
    public UserAlreadyExistException(String message){
        super(message);
    }
}
