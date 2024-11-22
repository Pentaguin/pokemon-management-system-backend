package com.example.PokemonManagementSystem.exception;

public class ShopItemNotFoundException extends RuntimeException {
    public ShopItemNotFoundException(String message) {
        super(message);
    }
}