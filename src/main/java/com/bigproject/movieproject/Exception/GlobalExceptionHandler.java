package com.bigproject.movieproject.Exception;


import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistException.class)
    public String servletRequestBindingException(ServletRequestBindingException e){
        System.out.println("SpringBlogException Occurred: "+ e.getMessage());
        return "error";
    }
}