package com.example.PokemonManagementSystem.web.controller;

import com.example.PokemonManagementSystem.service.ShopService;
import com.example.PokemonManagementSystem.web.dto.ShopDto;
import com.example.PokemonManagementSystem.web.mapper.ShopMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
@Tag(name = "/shop", description = "Operations on Shop")
public class ShopController {
    private final ShopService shopService;
    private final ShopMapper shopMapper;

    @PostMapping
    @Operation(summary = "Create a new shop")
    public ResponseEntity<ShopDto> createShop(){
        ShopDto createdShop = shopMapper.toDto(shopService.createShop());
        return new ResponseEntity<>(createdShop, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all shops")
    public ResponseEntity<List<ShopDto>> getShops(){
        List<ShopDto> createdShopDtos = shopMapper.toDtoList(shopService.getAllShops());
        return new ResponseEntity<>(createdShopDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{shopId}")
    @Operation(summary = "Delete a shop")
    public ResponseEntity<Void> deleteShop(@PathVariable Long shopId){
        shopService.deleteShopById(shopId);
        return ResponseEntity.ok().build();
    }
}