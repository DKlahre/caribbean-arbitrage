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

        transactionManagerRef = "tradeTransactionManager",
        entityManagerFactoryRef = "tradeEntityManagerFactory",
        basePackages = {"com.codeinvestigator.multiple_datasources.trade" }
)
public class ConfigureTradeDB {

    @Bean(name="tradeDSProps")
    @ConfigurationProperties("trade.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "tradeDataSource")
    @ConfigurationProperties(prefix = "trade.datasource")
    public DataSource tradeDataSource(@Qualifier("tradeDSProps") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "tradeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean tradeEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("tradeDataSource") DataSource tradeDataSource
    ) {
        return builder
                .dataSource(tradeDataSource)
                .packages( "com.codeinvestigator.multiple_datasources.trade")
                .persistenceUnit("trade")
                .build();
    }

    @Bean(name = "tradeTransactionManager")
    @ConfigurationProperties("trade.jpa")
    public PlatformTransactionManager tradeTransactionManager(
            @Qualifier("tradeEntityManagerFactory") EntityManagerFactory
                    tradeEntityManagerFactory
    ) {
        return new JpaTransactionManager(tradeEntityManagerFactory);
    }

}
