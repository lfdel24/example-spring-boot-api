package com.lfdel24.api.example.dto;

/**
 *
 * @author leo
 */
public class Message {
    
    private String message;
    private Object o;    
    
    public Message(String message) {
        this.message = message;
    }
    
    public Message(String message, Object o) {
        this.message = message;
        this.o = o;
    }
    
}
