package com.example.CodeReviewProject.controller;

import com.example.CodeReviewProject.entity.City;
import com.example.CodeReviewProject.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
public class CacheController {

    private CacheService cacheService;
    @Autowired
    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }



    @GetMapping("/allCity")
    public Map<String, City> getAllCity(){
        return cacheService.getAllCity();
    }

    @GetMapping("/city")
    public City getCityByName(@RequestParam("name") String name){
        return  cacheService.getZipCode(name);
    }

    @GetMapping("/cache")
    public Cache getCacheDetails(@RequestParam("name") String name){
        return cacheService.getCacheByName(name);
    }


    @PostMapping("/city")
    public City putCity(@RequestBody City city){
        return cacheService.putNewCity(city);
    }



    @DeleteMapping("/cache")
    public String deleteCity(){
        return cacheService.deleteCity();
    }

    @DeleteMapping("/delete")
    public void deleteCityFromMap(@RequestParam("name") String name){
         cacheService.deleteOneCity(name);
    }


}
