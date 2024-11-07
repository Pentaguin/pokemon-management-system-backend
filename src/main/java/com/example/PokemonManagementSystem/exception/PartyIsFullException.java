package com.example.PokemonManagementSystem.exception;

public class PartyIsFullException extends RuntimeException {
    public PartyIsFullException(String message) {
        super(message);
    }
}

