package com.example.PokemonManagementSystem.web.controller;

import com.example.PokemonManagementSystem.service.PlayerStatusService;
import com.example.PokemonManagementSystem.web.dto.PlayerStatusDto;
import com.example.PokemonManagementSystem.web.mapper.PlayerStatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playerstats")
@RequiredArgsConstructor
public class PlayerStatusController {
    private final PlayerStatusService playerStatusService;
    private final PlayerStatusMapper playerStatusMapper;

    @GetMapping
    public ResponseEntity<PlayerStatusDto> getStats() {
        return new ResponseEntity<>(playerStatusMapper.toDto(playerStatusService.getStats()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveStats(@RequestBody PlayerStatusDto playerStatusDto) {
        playerStatusService.saveStats(playerStatusMapper.toModel(playerStatusDto));
        return ResponseEntity.ok().build();
    }
}
