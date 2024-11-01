package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.model.PlayerStatus;
import com.example.PokemonManagementSystem.repository.PlayerStatusRepository;
import com.example.PokemonManagementSystem.web.dto.PlayerStatusDto;
import com.example.PokemonManagementSystem.web.mapper.PlayerStatusMapper;
import org.springframework.stereotype.Service;

@Service
public class PlayerStatusService {
    private final PlayerStatusRepository playerStatusRepository;
    private final PlayerStatusMapper playerStatusMapper;

    private PlayerStatusService(PlayerStatusRepository playerStatusRepository, PlayerStatusMapper playerStatusMapper){
        this.playerStatusRepository = playerStatusRepository;
        this.playerStatusMapper = playerStatusMapper;
    }

    public void saveStats(PlayerStatusDto playerStatusDto){
        PlayerStatus playerStatus = playerStatusRepository.findById(1L).orElse(new PlayerStatus());
        playerStatus.setGold(playerStatus.getGold());
        playerStatus.setClicks(playerStatusDto.getClicks());
        playerStatusRepository.save(playerStatus);
    }

    public PlayerStatusDto getStats(){
        PlayerStatus playerStatus = playerStatusRepository.findById(1L).orElse(new PlayerStatus());
        return playerStatusMapper.toDto(playerStatus);
    }
}
