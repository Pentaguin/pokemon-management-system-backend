package com.example.PokemonManagementSystem.web.controller;

import com.example.PokemonManagementSystem.service.StatsService;
import com.example.PokemonManagementSystem.web.dto.StatsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private final StatsService statsService;

    private StatsController(StatsService statsService){
        this.statsService = statsService;
    }

    @GetMapping
    public ResponseEntity<StatsDto> getStats() {
        return new ResponseEntity<>(statsService.getStats(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveStats(@RequestBody StatsDto statsDto) {
        statsService.saveStats(statsDto);
        return ResponseEntity.ok().build();
    }
}
