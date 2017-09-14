package com.hiberus.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;

/**
 * Created by Daniel on 09/06/2016.
 */
@EnableCaching
public class CacheConfig {

    /**
     * Factory Manager for EhCache.
     *
     * @return
     */
    @Bean(name = "ehcache")
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {

        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));

        return ehCacheManagerFactoryBean;
    }

    /**
     * CacheManager by Spring.
     *
     * @param ehCacheManagerFactoryBean
     * @return
     */
    @Bean(name = "cacheManager")
    public CacheManager cacheManager(
            @Qualifier(value = "ehcache") EhCacheManagerFactoryBean ehCacheManagerFactoryBean){

        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(ehCacheManagerFactoryBean.getObject());

        return ehCacheCacheManager;
    }

}