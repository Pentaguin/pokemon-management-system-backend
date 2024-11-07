package com.example.PokemonManagementSystem.repository;

import com.example.PokemonManagementSystem.model.Party;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends CrudRepository<Party,Long> {
}
