package com.example.PokemonManagementSystem.web.controller;

import com.example.PokemonManagementSystem.model.ShopItem;
import com.example.PokemonManagementSystem.service.ShopItemService;
import com.example.PokemonManagementSystem.web.dto.ShopItemTransactionDto;
import com.example.PokemonManagementSystem.web.dto.ShopItemDto;
import com.example.PokemonManagementSystem.web.mapper.ShopItemMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop/{shopId}/items")
@RequiredArgsConstructor
@Tag(name = "/shop/{shopId}/items", description = "Operations on ShopItems")
public class ShopItemController {
    private final ShopItemService shopItemService;
    private final ShopItemMapper shopItemMapper;

    @PostMapping
    @Operation(summary = "Add item to shop")
    public ResponseEntity<ShopItemDto> addShopItemToShop(@PathVariable Long shopId, @RequestBody ShopItemDto shopItemDto){
        ShopItem shopItem = shopItemMapper.toModel(shopItemDto);
        ShopItemDto createdShopItemDto = shopItemMapper.toDto(shopItemService.createShopItem(shopId,shopItem));
        return new ResponseEntity<>(createdShopItemDto, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all shop items")
    public ResponseEntity<List<ShopItemDto>> getShopItems(@PathVariable Long shopId){
        List<ShopItemDto> shopItemDtos = shopItemMapper.toDtoList(shopItemService.getShopItemsByShopId(shopId));
        return new ResponseEntity<>(shopItemDtos, HttpStatus.OK);
    }

    @GetMapping("/{shopItemId}")
    @Operation(summary = "Get 1 shop item")
    public ResponseEntity<ShopItemDto> getShopItem(@PathVariable Long shopId, @PathVariable Long shopItemId){
        ShopItemDto shopItemDto = shopItemMapper.toDto(shopItemService.getShopItemByIdAndByShopId(shopId,shopItemId));
        return new ResponseEntity<>(shopItemDto,HttpStatus.OK);
    }

    @PutMapping("/{shopItemId}")
    public ResponseEntity<Void> updateShopItems(@PathVariable Long shopId, @PathVariable Long shopItemId, @RequestBody ShopItemDto shopItemDto){
        shopItemService.updateShopItemById(shopId,shopItemId,shopItemMapper.toModel(shopItemDto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{shopItemId}")
    public ResponseEntity<Void> deleteShopItem(@PathVariable Long shopId, @PathVariable Long shopItemId){
        shopItemService.deleteShopItemById(shopId,shopItemId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/buy")
    @Operation(summary = "Buy item")
    public ResponseEntity<Void> buyShopItems(@PathVariable Long shopId, @RequestBody List<ShopItemTransactionDto> shopItemTransactionDtos){
        Map<Long, Integer> itemsWithQuantities = new HashMap<>();

        for (ShopItemTransactionDto dto : shopItemTransactionDtos) {
            itemsWithQuantities.put(dto.getItemId(), dto.getQuantity());
        }

        shopItemService.buyItems(shopId, itemsWithQuantities);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/sell")
    @Operation(summary = "Sell item")
    public ResponseEntity<Void> sellShopItems(@PathVariable Long shopId, @RequestBody List<ShopItemTransactionDto> shopItemTransactionDtos){
        Map<Long, Integer> itemsWithQuantities = new HashMap<>();

        for (ShopItemTransactionDto dto : shopItemTransactionDtos) {
            itemsWithQuantities.put(dto.getItemId(), dto.getQuantity());
        }

        shopItemService.sellItems(shopId, itemsWithQuantities);
        return ResponseEntity.ok().build();
    }
}