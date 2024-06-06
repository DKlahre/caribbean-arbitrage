package com.codeinvestigator.multiple_datasources.configure;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(

        transactionManagerRef = "orderTransactionManager",
        entityManagerFactoryRef = "orderEntityManagerFactory",
        basePackages = {"com.codeinvestigator.multiple_datasources.orderpojos" }
)
public class ConfigureOrdDB {

    @Bean(name="orderDSProps")
    @ConfigurationProperties("ord.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "orderDataSource")
    @ConfigurationProperties(prefix = "ord.datasource")
    public DataSource orderDataSource(@Qualifier("orderDSProps") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "orderEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean orderEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("orderDataSource") DataSource orderDataSource
    ) {
        return builder
                .dataSource(orderDataSource)
                .packages( "com.codeinvestigator.multiple_datasources.orderpojos")
                .persistenceUnit("ord")
                .build();
    }

    @Bean(name = "orderTransactionManager")
    @ConfigurationProperties("ord.jpa")
    public PlatformTransactionManager orderTransactionManager(
            @Qualifier("orderEntityManagerFactory") EntityManagerFactory
                    orderEntityManagerFactory
    ) {
        return new JpaTransactionManager(orderEntityManagerFactory);
    }
}
