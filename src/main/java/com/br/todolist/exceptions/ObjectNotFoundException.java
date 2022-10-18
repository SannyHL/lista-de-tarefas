package com.br.todolist.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    
    public ObjectNotFoundException(String message){
        super(message);
    }
}
