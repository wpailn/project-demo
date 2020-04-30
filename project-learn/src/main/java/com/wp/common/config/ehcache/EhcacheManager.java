package com.wp.common.config.ehcache;

import lombok.Data;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.PooledExecutionServiceConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

@Data
public class EhcacheManager {

    private CacheManager cacheManager;

    public void init(){
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .using(PooledExecutionServiceConfigurationBuilder.newPooledExecutionServiceConfigurationBuilder()
                        .pool("defaultEventPool", 1, 3)
                        .pool("cache2Pool", 2, 2)
                        .build())
                .withCache("cache1",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, String.class, ResourcePoolsBuilder.heap(10)))
                .withCache("cache2",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, String.class, ResourcePoolsBuilder.heap(10)))
                .build();
        cacheManager.init();
    }

    public void destroy(){
        cacheManager.close();
    }
}
