package com.example.PokemonManagementSystem.exception;

public class NotEnoughGoldException extends RuntimeException {
    public NotEnoughGoldException(String message) {
        super(message);
    }
}
