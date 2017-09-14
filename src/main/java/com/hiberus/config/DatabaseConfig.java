package com.hiberus.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Daniel Pardo Ligorred.
 */
@PropertySource("classpath:persistence.properties")
@ComponentScan(basePackages = "com.hiberus.api.dao")
@EnableTransactionManagement
class DatabaseConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(this.env.getProperty("dataSource.driverClassName"));
        dataSource.setUrl(this.env.getProperty("dataSource.url"));
        dataSource.setUsername(this.env.getProperty("dataSource.username"));
        dataSource.setPassword(this.env.getProperty("dataSource.password"));

        return dataSource;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean entityManagerFactory(DataSource dataSource) {

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan("com.hiberus.api.model");

        localSessionFactoryBean.setHibernateProperties(this.hibernateProperties());

        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

        return new HibernateTransactionManager(sessionFactory);
    }

    private Properties hibernateProperties() {

        return new Properties() {{
            // This property sets the dialect which Hibernate speaks with DBMS.
            setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
            // This property is set to update the table schema when model changes.
            setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
            // This property is set to show queries in log.
            setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

            // Number of connections to adquire when queue is exhaust.
            setProperty("hibernate.c3p0.acquire_increment", env.getProperty("hibernate.c3p0.acquire_increment"));
            // Minimum number of JDBC connections in queue. 1 by default.
            setProperty("hibernate.c3p0.min_size", env.getProperty("hibernate.c3p0.min_size"));
            // Maximum number of JDBC connections in queue. 100 by default.
            setProperty("hibernate.c3p0.max_size", env.getProperty("hibernate.c3p0.max_size"));
            // Timeout for removing idle connections. 0 by default, will never removed.
            setProperty("hibernate.c3p0.timeout", env.getProperty("hibernate.c3p0.timeout"));
            // Number of cached connections established. 0 by default, caching disabled.
            setProperty("hibernate.c3p0.max_statements", env.getProperty("hibernate.c3p0.max_statements"));
            // Time in seconds before validate the connection. 0 by default.
            setProperty("hibernate.c3p0.idle_test_period", env.getProperty("hibernate.c3p0.idle_test_period"));
        }};
    }

}