package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.model.PlayerStatus;
import com.example.PokemonManagementSystem.repository.PlayerStatusRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerStatusServiceTest {

    @InjectMocks
    private PlayerStatusService playerStatusService;

    @Mock
    private PlayerStatusRepository playerStatusRepository;

    @Test
    public void givenPlayerStatus_whenGetStats_thenReturnPlayerStatus() {
        // Given
        PlayerStatus mockPlayerStatus = new PlayerStatus();
        mockPlayerStatus.setGold(100);
        mockPlayerStatus.setClicks(300);

        when(playerStatusRepository.findById(1L)).thenReturn(Optional.of(mockPlayerStatus));

        // When
        PlayerStatus result = playerStatusService.getStats();

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getClicks()).isEqualTo(mockPlayerStatus.getClicks());
        assertThat(result.getGold()).isEqualTo(mockPlayerStatus.getGold());
    }

    @Test
    public void givenPlayerStatus_whenSaveStatsAndExistingStatsNotExist_thenPlayerStatusSaved() {
        // Given
        PlayerStatus playerStatus = new PlayerStatus();
        playerStatus.setGold(50);
        playerStatus.setClicks(100);

        when(playerStatusRepository.findById(1L)).thenReturn(Optional.empty());

        // When
        playerStatusService.saveStats(playerStatus);

        // Then
        verify(playerStatusRepository, times(1)).save(any(PlayerStatus.class));
        ArgumentCaptor<PlayerStatus> playerStatusCaptor = ArgumentCaptor.forClass(PlayerStatus.class);
        verify(playerStatusRepository).save(playerStatusCaptor.capture());

        PlayerStatus capturedStatus = playerStatusCaptor.getValue();
        assertNotNull(capturedStatus);
        assertEquals(50, capturedStatus.getGold());
        assertEquals(100, capturedStatus.getClicks());

    }

    @Test
    public void givenExistingPlayerStatus_whenSaveStats_thenExistingPlayerStatusUpdatedAndSaved() {
        // Given
        PlayerStatus existingPlayerStatus = new PlayerStatus();
        existingPlayerStatus.setGold(50);
        existingPlayerStatus.setClicks(80);

        PlayerStatus updatedPlayerStatus = new PlayerStatus();
        updatedPlayerStatus.setGold(200);
        updatedPlayerStatus.setClicks(100);

        when(playerStatusRepository.findById(1L)).thenReturn(Optional.of(existingPlayerStatus));

        // When
        playerStatusService.saveStats(updatedPlayerStatus);

        // Then
        verify(playerStatusRepository, times(1)).findById(1L);

        // Verify that the updated player status is saved
        ArgumentCaptor<PlayerStatus> playerStatusCaptor = ArgumentCaptor.forClass(PlayerStatus.class);
        verify(playerStatusRepository, times(1)).save(playerStatusCaptor.capture());
        PlayerStatus savedPlayerStatus = playerStatusCaptor.getValue();
        assertNotNull(savedPlayerStatus);
        assertEquals(200, savedPlayerStatus.getGold());
        assertEquals(100, savedPlayerStatus.getClicks());
    }

}
