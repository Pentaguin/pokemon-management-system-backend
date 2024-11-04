package com.example.PokemonManagementSystem.web.controller;

import com.example.PokemonManagementSystem.model.ShopItem;
import com.example.PokemonManagementSystem.service.ShopItemService;
import com.example.PokemonManagementSystem.service.ShopService;
import com.example.PokemonManagementSystem.web.dto.ShopDto;
import com.example.PokemonManagementSystem.web.dto.ShopItemDto;
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
    public ResponseEntity<ShopDto> createShop(){
        return new ResponseEntity<>(shopService.createShop(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ShopDto>> getShops(){
        return new ResponseEntity<>(shopService.getAllShops(), HttpStatus.OK);
    }

    // TODO DELETE SHOP

    @GetMapping("/items/{shopId}")
    public ResponseEntity<List<ShopItemDto>> getShopItemsByShopId(@PathVariable Long shopId){
        return new ResponseEntity<>(shopItemService.getShopItemsByShopId(shopId), HttpStatus.OK);
    }

    @PutMapping("/items/{shopItemId}")
    public void updateShopItems(){

    }

    @PostMapping("/items/{shopId}")
    public ResponseEntity<ShopItemDto> addShopitemToShop(@PathVariable Long shopId, @RequestBody ShopItemDto shopItemDto){
        return new ResponseEntity<>(shopItemService.createShopItem(shopId, shopItemDto), HttpStatus.CREATED);
    }
}
