package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.model.PlayerStatus;
import com.example.PokemonManagementSystem.repository.PlayerStatusRepository;
import com.example.PokemonManagementSystem.web.dto.PlayerStatusDto;
import com.example.PokemonManagementSystem.web.mapper.PlayerStatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerStatusService {
    private final PlayerStatusRepository playerStatusRepository;
    private final PlayerStatusMapper playerStatusMapper;

    public void saveStats(PlayerStatusDto playerStatusDto){
        PlayerStatus playerStatus = playerStatusRepository.findById(1L).orElse(new PlayerStatus());
        playerStatus.setGold(playerStatusDto.getGold());
        playerStatus.setClicks(playerStatusDto.getClicks());
        playerStatusRepository.save(playerStatus);
    }

    public PlayerStatusDto getStats(){
        PlayerStatus playerStatus = playerStatusRepository.findById(1L).orElse(new PlayerStatus());
        return playerStatusMapper.toDto(playerStatus);
    }

//    public void updateGold(int newGoldAmount){
//        PlayerStatusDto playerStatusDto = getStats();
//        playerStatusDto.setGold(newGoldAmount);
//        saveStats(playerStatusDto);
//    }
}
