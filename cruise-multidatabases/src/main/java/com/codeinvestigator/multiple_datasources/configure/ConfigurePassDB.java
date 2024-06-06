package com.codeinvestigator.multiple_datasources.configure;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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

        transactionManagerRef = "passengerTransactionManager",
        entityManagerFactoryRef = "passengerEntityManagerFactory",
        basePackages = { "com.codeinvestigator.multiple_datasources.pass" }
)
public class ConfigurePassDB {

    @Primary
    @Bean(name="passengerDSProps")
    @ConfigurationProperties("passeng.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "passengerDataSource")
    @ConfigurationProperties(prefix = "passeng.datasource")
    public DataSource passengerDataSource(@Qualifier("passengerDSProps") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "passengerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean passengerEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("passengerDataSource") DataSource passengerDataSource
    ) {
        return builder
                .dataSource(passengerDataSource)
                .packages("com.codeinvestigator.multiple_datasources.pass")
                .persistenceUnit("pass")
                .build();
    }

    @Primary
    @Bean(name = "passengerTransactionManager")
    @ConfigurationProperties("passeng.jpa")
    public PlatformTransactionManager passengerTransactionManager(
            @Qualifier("passengerEntityManagerFactory") EntityManagerFactory
                    passengerEntityManagerFactory
    ) {
        return new JpaTransactionManager(passengerEntityManagerFactory);
    }
}