package com.example.currencyexchange;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.currenclyexchange",entityManagerFactoryRef ="entityManager" ,
transactionManagerRef = "transactionManager")
public class DataSourceConfiguration {

	private LocalContainerEntityManagerFactoryBean entityManger;
	
	
	@Bean
	public DataSource getDataSource() {
		/*
		 * spring.datasource.url = jdbc:h2:mem:testb
		 * spring.datasource.driver-class-name=org.h2.Driver spring.datasource.username
		 * = sa spring.datasource.password =
		 */
	
DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder.url("jdbc:h2:mem:testb");
		dataSourceBuilder.username("sa");
		//dataSourceBuilder.password("");
		return dataSourceBuilder.build();
		
	}
	@Bean(name="entityManager")
	public LocalContainerEntityManagerFactoryBean getEntityManger(EntityManagerFactoryBuilder builder) {
		
		 LocalContainerEntityManagerFactoryBean entityManger = builder.dataSource(getDataSource()).packages("com.example.currenclyexchange").build();
		 this.entityManger = entityManger;
		 System.out.println("****entity manager *******88");
		 return entityManger;
	}
	
	@Bean(name="transactionManager")
	public PlatformTransactionManager getTransactionManger(EntityManagerFactoryBuilder builder) {
		 System.out.println("****Transaction manager *******88");
		return new JpaTransactionManager(entityManger.getObject());
		
	}
}
