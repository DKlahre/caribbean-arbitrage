package com.codeinvestigator.multiple_datasources.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Integer id) {
        super ("Could not find the user with id " + id);
    }
}
