package com.wp.common.config.ehcache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EhcacheConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public EhcacheManager ehcacheManager(){
        return new EhcacheManager();
    }
}
