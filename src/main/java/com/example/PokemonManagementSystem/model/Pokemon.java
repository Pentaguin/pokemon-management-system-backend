package com.example.PokemonManagementSystem.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pokeApiId;
    private String name;
    private String imageUrl;
    private String type;
    private Integer generation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "box_id")
    @Nullable
    private Box box;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    @Nullable
    private Team team;
}
