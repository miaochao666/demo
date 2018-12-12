package com.example.demo.utils;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;


public class CacheUtil {

    private static CacheManager cacheManager;

    public void setCache(String cacheName,String cacheKey,Object cacheValue){
        Cache cache=cacheManager.getCache(cacheName);
        if (null!=cache){

        }

    }
}
