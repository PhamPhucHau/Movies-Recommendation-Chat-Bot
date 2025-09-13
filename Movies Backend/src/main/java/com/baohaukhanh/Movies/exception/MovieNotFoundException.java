package com.baohaukhanh.Movies.exception;

public class MovieNotFoundException extends RuntimeException {
    
    public MovieNotFoundException(String message) {
        super(message);
    }
    
    public MovieNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

