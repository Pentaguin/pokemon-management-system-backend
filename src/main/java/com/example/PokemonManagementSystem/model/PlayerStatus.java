package com.example.PokemonManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "playerstatus")
public class PlayerStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int clicks;
    private double gold;
}
