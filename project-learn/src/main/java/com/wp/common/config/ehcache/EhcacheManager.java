package com.wp.common.config.ehcache;

import lombok.Data;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.*;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.event.EventType;
import org.ehcache.xml.XmlConfiguration;

import java.net.URL;

@Data
public class EhcacheManager {

    private CacheManager cacheManager;

    public void init(){
        URL myUrl = getClass().getResource("/ehcache.xml");
        Configuration xmlConfig = new XmlConfiguration(myUrl);
        cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        cacheManager.init();
    }

    public void destroy(){
        cacheManager.close();
    }
}
