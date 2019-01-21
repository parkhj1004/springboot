package com.jpa.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = {"com.jpa.demo.config"}
//        , repositoryBaseClass = DbConfig.class
//        ,entityManagerFactoryRef = "entityManagerFactoryJpa"
//        ,transactionManagerRef = "transactionManagerJpa"
//)
@MapperScan(basePackages = "com" , annotationClass = com.crypto.batch.config.db.annotation.DbConnection.class , sqlSessionFactoryRef = "dbSqlSessionFactory")
public class DbConfig {

    @Bean("dataSource_")
    @ConfigurationProperties(prefix = "spring.datasource.dbinfo")
//    @Primary
    public DataSource dataSource() throws SQLException {

        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }


    @Bean(name = "dbSqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("dataSource_") DataSource dataSource) throws Exception {

        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setTypeAliasesPackage("com");
        sqlSessionFactoryBean.setConfigLocation(patternResolver.getResource("classpath:/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(patternResolver.getResources("classpath:/com/mapper/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "dbTransactionManager")
    public PlatformTransactionManager platformTransactionManager (@Qualifier("dataSource_") DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        transactionManager.setGlobalRollbackOnParticipationFailure(false);

        return transactionManager;
    }




}
