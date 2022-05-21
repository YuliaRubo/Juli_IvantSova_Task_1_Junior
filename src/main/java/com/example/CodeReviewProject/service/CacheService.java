package com.example.CodeReviewProject.service;

import com.example.CodeReviewProject.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


    @Service
    public class CacheService {
        @Autowired
        CacheManager cacheManager;

        Map<String, City> cityZipCodeMap;
        {
            cityZipCodeMap = new HashMap<>();
            cityZipCodeMap.put("Minsk", City.builder().cityName("Minsk").zipCode("222222").build());
            cityZipCodeMap.put("Brest", City.builder().cityName("Brest").zipCode("333333").build());
            cityZipCodeMap.put("Gomel", City.builder().cityName("Gomel").zipCode("444444").build());
            cityZipCodeMap.put("Braslav", City.builder().cityName("Braslav").zipCode("555555").build());

        }

        public Map<String,City> getAllCity(){
            return cityZipCodeMap;

        }

        @Cacheable(value = "city-zip-cache")
        public City getZipCode(String cityName){
            System.out.println("getZipCode method called");
            return cityZipCodeMap.get(cityName);
        }

        public Cache getCacheByName(String cacheName){
            return  cacheManager.getCache(cacheName);
        }

        @CachePut(value = "city-zip-cache", key = "#city.cityName")
        public City putNewCity(City city){
           cityZipCodeMap.put(city.getCityName(),city);
           return city;
        }


        @CacheEvict(value = "city-zip-cache", allEntries = true)
        public String deleteCity(){
           return "Delete cache Successfully";
        }
        @CacheEvict(value = "city-zip-cache")
        public void deleteOneCity(String cityName){
            cityZipCodeMap.remove(cityName);


        }


    }

