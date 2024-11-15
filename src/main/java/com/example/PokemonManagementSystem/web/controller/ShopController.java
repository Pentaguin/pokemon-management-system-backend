package com.example.PokemonManagementSystem.web.controller;

import com.example.PokemonManagementSystem.model.ShopItem;
import com.example.PokemonManagementSystem.service.ShopItemService;
import com.example.PokemonManagementSystem.service.ShopService;
import com.example.PokemonManagementSystem.web.dto.ShopDto;
import com.example.PokemonManagementSystem.web.dto.ShopItemDto;
import com.example.PokemonManagementSystem.web.mapper.ShopItemMapper;
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
    private final ShopItemService shopItemService;
    private final ShopItemMapper shopItemMapper;
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

    @PostMapping("/{shopId}/items")
    @Operation(summary = "Add item to shop")
    public ResponseEntity<ShopItemDto> addShopItemToShop(@PathVariable Long shopId, @RequestBody ShopItemDto shopItemDto){
        ShopItem shopItem = shopItemMapper.toModel(shopItemDto);
        ShopItemDto createdShopItemDto = shopItemMapper.toDto(shopItemService.createShopItem(shopId,shopItem));
        return new ResponseEntity<>(createdShopItemDto, HttpStatus.CREATED);
    }

    @GetMapping("/{shopId}/items")
    @Operation(summary = "Get all shop items")
    public ResponseEntity<List<ShopItemDto>> getShopItems(@PathVariable Long shopId){
        List<ShopItemDto> shopItemDtos = shopItemMapper.toDtoList(shopItemService.getShopItemsByShopId(shopId));
        return new ResponseEntity<>(shopItemDtos, HttpStatus.OK);
    }

    @GetMapping("/{shopId}/items/{shopItemId}")
    @Operation(summary = "Get 1 shop item")
    public ResponseEntity<ShopItemDto> getShopItem(@PathVariable Long shopId, @PathVariable Long shopItemId){
        ShopItemDto shopItemDto = shopItemMapper.toDto(shopItemService.getShopItemByIdAndByShopId(shopId,shopItemId));
        return new ResponseEntity<>(shopItemDto,HttpStatus.OK);
    }

//    @PutMapping("/{shopId}/items/{shopItemId}")
//    public void updateShopItems(@PathVariable Long shopId, @PathVariable Long shopItemId, @RequestBody ShopItemDto shopItemDto){
//        // TODO
//    }
//
//    @DeleteMapping("/{shopId}/items/{shopItemId}")
//    public void deleteShopItems(@PathVariable Long shopId, @PathVariable Long shopItemId){
//        // TODO
//    }


}
