package com.example.PokemonManagementSystem.web.controller;

import com.example.PokemonManagementSystem.service.ShopItemService;
import com.example.PokemonManagementSystem.service.ShopService;
import com.example.PokemonManagementSystem.web.dto.ShopDto;
import com.example.PokemonManagementSystem.web.dto.ShopItemDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final ShopService shopService;
    private final ShopItemService shopItemService;

    private ShopController(ShopService shopService, ShopItemService shopItemService){
        this.shopService = shopService;
        this.shopItemService = shopItemService;
    }

    @PostMapping
    @Operation(summary = "Create a new shop")
    public ResponseEntity<ShopDto> createShop(){
        return new ResponseEntity<>(shopService.createShop(), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all shops")
    public ResponseEntity<List<ShopDto>> getShops(){
        return new ResponseEntity<>(shopService.getAllShops(), HttpStatus.OK);
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
        return new ResponseEntity<>(shopItemService.createShopItem(shopId, shopItemDto), HttpStatus.CREATED);
    }

    @GetMapping("/{shopId}/items")
    @Operation(summary = "Get all shop items")
    public ResponseEntity<List<ShopItemDto>> getShopItems(@PathVariable Long shopId){
        return new ResponseEntity<>(shopItemService.getShopItemsByShopId(shopId), HttpStatus.OK);
    }

    @GetMapping("/{shopId}/items/{shopItemId}")
    @Operation(summary = "Get 1 shop item")
    public ResponseEntity<ShopItemDto> getShopItem(@PathVariable Long shopId, @PathVariable Long shopItemId){
        return new ResponseEntity<>(shopItemService.getShopItemByIdAndByShopId(shopId,shopItemId),HttpStatus.OK);
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
