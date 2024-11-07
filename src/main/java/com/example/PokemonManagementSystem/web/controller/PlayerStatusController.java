package com.example.PokemonManagementSystem.web.controller;

import com.example.PokemonManagementSystem.service.PlayerStatusService;
import com.example.PokemonManagementSystem.web.dto.PlayerStatusDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playerstats")
public class PlayerStatusController {

    private final PlayerStatusService playerStatusService;

    private PlayerStatusController(PlayerStatusService playerStatusService){
        this.playerStatusService = playerStatusService;
    }

    @GetMapping
    public ResponseEntity<PlayerStatusDto> getStats() {
        return new ResponseEntity<>(playerStatusService.getStats(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveStats(@RequestBody PlayerStatusDto playerStatusDto) {
        playerStatusService.saveStats(playerStatusDto);
        return ResponseEntity.ok().build();
    }
}
