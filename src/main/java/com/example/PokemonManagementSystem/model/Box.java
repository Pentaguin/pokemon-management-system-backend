package com.example.PokemonManagementSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "box", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pokemon> pokemons = new ArrayList<>();

}