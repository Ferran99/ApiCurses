package com.lallucana.API.Persistance.Exceptions;

public class ErrorRequest extends Exception{
    public ErrorRequest() {
        super("Error getting data from url");
    }
}
