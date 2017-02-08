package com.huawei;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

    @Bean(name = "projectDataSource")
    @Qualifier("projectDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.project")
    public DataSource projectDataSource() {
        return (DataSource) DataSourceBuilder.create().build();
    }

    @Bean(name = "scenarioDataSource")
    @Qualifier("scenarioDataSource")
    @ConfigurationProperties(prefix="spring.datasource.scenario")
    public DataSource scenarioDataSource() {
        return (DataSource) DataSourceBuilder.create().build();
    }

}
