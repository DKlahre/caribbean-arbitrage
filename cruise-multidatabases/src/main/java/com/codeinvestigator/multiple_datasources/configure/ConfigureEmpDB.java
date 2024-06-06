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

        transactionManagerRef = "employeeTransactionManager",
        entityManagerFactoryRef = "employeeEntityManagerFactory",
        basePackages = { "com.codeinvestigator.multiple_datasources.emp" }
)
public class ConfigureEmpDB {

    @Bean(name="employeeDSProps")
    @ConfigurationProperties("employ.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "employeeDataSource")
    @ConfigurationProperties(prefix = "employ.datasource")
    public DataSource employeeDataSource(@Qualifier("employeeDSProps") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "employeeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean employeeEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("employeeDataSource") DataSource employeeDataSource
    ) {
        return builder
                .dataSource(employeeDataSource)
                .packages("com.codeinvestigator.multiple_datasources.emp")
                .persistenceUnit("emp")
                .build();
    }

    @Bean(name = "employeeTransactionManager")
    @ConfigurationProperties("employ.jpa")
    public PlatformTransactionManager employeeTransactionManager(
            @Qualifier("employeeEntityManagerFactory") EntityManagerFactory
                    employeeEntityManagerFactory
    ) {
        return new JpaTransactionManager(employeeEntityManagerFactory);
    }
}
