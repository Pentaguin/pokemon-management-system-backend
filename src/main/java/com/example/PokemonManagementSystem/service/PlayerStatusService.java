package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.model.PlayerStatus;
import com.example.PokemonManagementSystem.repository.PlayerStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerStatusService {
    private final PlayerStatusRepository playerStatusRepository;

    public void saveStats(PlayerStatus updatedplayerStatus){
        PlayerStatus playerStatus = playerStatusRepository.findById(1L).orElse(new PlayerStatus());
        playerStatus.setGold(updatedplayerStatus.getGold());
        playerStatus.setClicks(updatedplayerStatus.getClicks());
        playerStatusRepository.save(playerStatus);
    }

    public PlayerStatus getStats(){
        return playerStatusRepository.findById(1L).orElse(new PlayerStatus());
    }

//    public void updateGold(int newGoldAmount){
//        PlayerStatusDto playerStatusDto = getStats();
//        playerStatusDto.setGold(newGoldAmount);
//        saveStats(playerStatusDto);
//    }
}
