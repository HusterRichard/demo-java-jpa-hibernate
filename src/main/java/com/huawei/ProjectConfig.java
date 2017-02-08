package com.huawei;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryProject",
        transactionManagerRef="transactionManagerProject",
        basePackages= { "com.huawei.domain.project" })
public class ProjectConfig {

    @Autowired 
    @Qualifier("projectDataSource")
    private DataSource projectDataSource;

    @Primary
    @Bean(name = "entityManagerProject")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryProject(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryProject")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryProject (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(projectDataSource)
                .properties(getVendorProperties(projectDataSource))
                .packages("com.huawei.domain.project")
                .persistenceUnit("projectPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "transactionManagerProject")
    public PlatformTransactionManager transactionManagerProject(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryProject(builder).getObject());
    }

}