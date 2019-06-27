package com.jpa.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
//@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.jpa.demo.config"}
        , repositoryBaseClass = JpaConfig.class
        ,entityManagerFactoryRef = "entityManagerFactory"
        ,transactionManagerRef = "transactionManager"
)
public class JpaConfig {


    @Bean("dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.jpadbinfo")
    @Primary
    public DataSource dataSource() throws SQLException {

        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    //    @Bean("entityManagerFactoryJpa")
    @Bean(name = "entityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource") DataSource dataSource) {

        return builder.dataSource(dataSource)
                .packages("com.jpa.demo").build();
    }

    //    @Primary
    @Bean(name = "transactionManager")
//    @Bean("transactionManagerJpa")
    @Primary
    public PlatformTransactionManager transactionManager(

            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

}