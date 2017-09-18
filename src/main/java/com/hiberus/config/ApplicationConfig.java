package com.hiberus.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.hiberus.api.service")
@Import({DatabaseConfig.class, CacheConfig.class})
public class ApplicationConfig {

    /**
     * Enables ${...} placeholders within bean definition property values and @Value annotation against
     * the current Spring enviroment.
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

        return new PropertySourcesPlaceholderConfigurer();
    }

}