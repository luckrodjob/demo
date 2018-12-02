package com.example;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( basePackages= {"com.example.demo.dao"},entityManagerFactoryRef="entityManagerFactory",transactionManagerRef="transactionManager")
public class JPAConfig {

	@Autowired
    private Environment env;
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private JpaProperties jpaProperties;

     @Bean
    public DataSource dataSource() {
    	 DriverManagerDataSource  dataSource = new DriverManagerDataSource ();
         dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
         dataSource.setUrl(env.getProperty("spring.datasource.url"));
         dataSource.setUsername(env.getProperty("spring.datasource.username"));
         dataSource.setPassword(env.getProperty("spring.datasource.password"));
         return dataSource;
    }
    
    @Primary
    @Bean("entityManager")
    public EntityManager  entityManger(EntityManagerFactoryBuilder builder) {
    	return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }
	
    @Primary
    @Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
	    return builder.dataSource(dataSource).packages("com.example.demo").properties(jpaProperties.getProperties()).persistenceUnit("primaryPersistenceUnit").build();
	}
    @Primary
	@Bean(name="transactionManager")
	public JpaTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
	    JpaTransactionManager transactionManager = 
	        new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(
	    		entityManagerFactoryPrimary(builder).getObject());
	    return transactionManager;
	}
}
