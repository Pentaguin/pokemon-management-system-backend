package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.model.Stats;
import com.example.PokemonManagementSystem.repository.StatsRepository;
import com.example.PokemonManagementSystem.web.dto.StatsDto;
import com.example.PokemonManagementSystem.web.mapper.StatsMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatsServiceTest {

    @InjectMocks
    private StatsService statsService;

    @Mock
    private StatsRepository statsRepository;

    @Mock
    private StatsMapper statsMapper;

    @Test
    public void testGetStats() {
        // Arrange
        Stats mockStats = new Stats();
        mockStats.setGold(100);
        mockStats.setClicks(300);

        StatsDto mockStatsDto = new StatsDto();
        mockStatsDto.setGold(100);
        mockStatsDto.setClicks(300);

        when(statsRepository.findById(1L)).thenReturn(Optional.of(mockStats));
        when(statsMapper.toDto(mockStats)).thenReturn(mockStatsDto);

        // Act
        StatsDto result = statsService.getStats();

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getClicks()).isEqualTo(mockStats.getClicks());
        assertThat(result.getGold()).isEqualTo(mockStats.getGold());
    }

    @Test
    public void testSaveStatsCreatesNewStatsWhenNoneExists() {
        // Arrange
        StatsDto statsDto = new StatsDto();
        statsDto.setGold(50);
        statsDto.setClicks(100);

        when(statsRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        statsService.saveStats(statsDto);

        // Assert
        verify(statsRepository).save(any(Stats.class));
    }

    @Test
    public void testSaveStatsUpdatesExistingStats() {
        // Arrange
        Stats existingStats = new Stats();
        existingStats.setGold(50);
        existingStats.setClicks(80);

        StatsDto statsDto = new StatsDto();
        statsDto.setClicks(100);

        when(statsRepository.findById(1L)).thenReturn(Optional.of(existingStats));

        // Act
        statsService.saveStats(statsDto);

        // Assert
        verify(statsRepository).save(existingStats);
        assert(existingStats.getClicks() == 100);
        assert(existingStats.getGold() == 50);
    }
}
