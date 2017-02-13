package br.com.devcave.recruiters.config;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

/**
 * Created by s2it_ocanalias on 2/8/17.
 */
@Configuration
@Slf4j
public class CacheConfiguration {
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(
                buildAreaCache()));
        return simpleCacheManager;
    }

    private GuavaCache buildAreaCache() {
        return new GuavaCache("area", CacheBuilder
                .newBuilder()
                .maximumSize(500)
                .expireAfterAccess(1, TimeUnit.DAYS)
                .build(),
                true);
    }

}
