package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.model.PlayerStatus;
import com.example.PokemonManagementSystem.repository.PlayerStatusRepository;
import com.example.PokemonManagementSystem.web.dto.PlayerStatusDto;
import com.example.PokemonManagementSystem.web.mapper.PlayerStatusMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerStatusServiceTest {

    @InjectMocks
    private PlayerStatusService playerStatusService;

    @Mock
    private PlayerStatusRepository playerStatusRepository;

    @Mock
    private PlayerStatusMapper playerStatusMapper;

    @Test
    public void testGetStats() {
        // Arrange
        PlayerStatus mockPlayerStatus = new PlayerStatus();
        mockPlayerStatus.setGold(100);
        mockPlayerStatus.setClicks(300);

        PlayerStatusDto mockPlayerStatusDto = new PlayerStatusDto();
        mockPlayerStatusDto.setGold(100);
        mockPlayerStatusDto.setClicks(300);

        when(playerStatusRepository.findById(1L)).thenReturn(Optional.of(mockPlayerStatus));
        when(playerStatusMapper.toDto(mockPlayerStatus)).thenReturn(mockPlayerStatusDto);

        // Act
        PlayerStatusDto result = playerStatusService.getStats();

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getClicks()).isEqualTo(mockPlayerStatus.getClicks());
        assertThat(result.getGold()).isEqualTo(mockPlayerStatus.getGold());
    }

    @Test
    public void testSaveStatsCreatesNewStatsWhenNoneExists() {
        // Arrange
        PlayerStatusDto playerStatusDto = new PlayerStatusDto();
        playerStatusDto.setGold(50);
        playerStatusDto.setClicks(100);

        when(playerStatusRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        playerStatusService.saveStats(playerStatusDto);

        // Assert
        verify(playerStatusRepository).save(any(PlayerStatus.class));
    }

    @Test
    public void testSaveStatsUpdatesExistingStats() {
        // Arrange
        PlayerStatus existingPlayerStatus = new PlayerStatus();
        existingPlayerStatus.setGold(50);
        existingPlayerStatus.setClicks(80);

        PlayerStatusDto playerStatusDto = new PlayerStatusDto();
        playerStatusDto.setClicks(100);

        when(playerStatusRepository.findById(1L)).thenReturn(Optional.of(existingPlayerStatus));

        // Act
        playerStatusService.saveStats(playerStatusDto);

        // Assert
        verify(playerStatusRepository).save(existingPlayerStatus);
        assert(existingPlayerStatus.getClicks() == 100);
        assert(existingPlayerStatus.getGold() == 50);
    }
}
