package com.example.PokemonManagementSystem.web.transformer;

import com.example.PokemonManagementSystem.model.Box;
import com.example.PokemonManagementSystem.model.Pokemon;
import com.example.PokemonManagementSystem.model.Team;
import com.example.PokemonManagementSystem.repository.BoxRepository;
import com.example.PokemonManagementSystem.repository.TeamRepository;
import com.example.PokemonManagementSystem.web.dto.PokemonDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PokemonTransformer {
    private final BoxRepository boxRepository;
    private final TeamRepository teamRepository;

    private PokemonTransformer(BoxRepository boxRepository, TeamRepository teamRepository){
        this.boxRepository = boxRepository;
        this.teamRepository = teamRepository;
    }

    public PokemonDto toDto(Pokemon pokemon) {
        PokemonDto dto = new PokemonDto();
        dto.setId(pokemon.getId());
        dto.setPokeApiId(pokemon.getPokeApiId());
        dto.setName(pokemon.getName());
        dto.setImageUrl(pokemon.getImageUrl());
        dto.setType(pokemon.getType());
        dto.setGeneration(pokemon.getGeneration());
        dto.setBoxId(pokemon.getBox() != null ? pokemon.getBox().getId() : null);
        dto.setTeamId(pokemon.getTeam() != null ? pokemon.getTeam().getId() : null);
        return dto;
    }

    public Pokemon toModel(PokemonDto dto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setPokeApiId(dto.getPokeApiId());
        pokemon.setName(dto.getName());
        pokemon.setImageUrl(dto.getImageUrl());
        pokemon.setType(dto.getType());
        pokemon.setGeneration(dto.getGeneration());

        if (dto.getBoxId() != null) {
            Optional<Box> boxOptional = boxRepository.findById(dto.getBoxId());
            boxOptional.ifPresent(pokemon::setBox);
        }

        if (dto.getTeamId() != null) {
            Optional<Team> teamOptional = teamRepository.findById(dto.getTeamId());
            teamOptional.ifPresent(pokemon::setTeam);
        }
        return pokemon;
    }
}
