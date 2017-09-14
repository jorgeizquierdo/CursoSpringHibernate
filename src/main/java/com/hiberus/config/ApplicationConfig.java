package com.hiberus.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.hiberus.api.service")
/*@ComponentScan(
        basePackages = "com.hiberus.api.service",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.hiberus.api.service.impl.practice.BeanServiceTwo")})*/
/*@ComponentScan(
        basePackages = "com.hiberus.api.service",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = BeanServiceTwo.class)})*/
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