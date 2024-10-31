package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.model.Stats;
import com.example.PokemonManagementSystem.repository.StatsRepository;
import com.example.PokemonManagementSystem.web.dto.StatsDto;
import com.example.PokemonManagementSystem.web.mapper.StatsMapper;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    private final StatsRepository statsRepository;
    private final StatsMapper statsMapper;

    private StatsService(StatsRepository statsRepository, StatsMapper statsMapper){
        this.statsRepository = statsRepository;
        this.statsMapper = statsMapper;
    }

    public void saveStats(StatsDto statsDto){
        statsRepository.save(statsMapper.toModel(statsDto));
    }

    public StatsDto getStats(){
        Stats stats = statsRepository.findById(1L).orElse(new Stats());
        return statsMapper.toDto(stats);
    }
}
