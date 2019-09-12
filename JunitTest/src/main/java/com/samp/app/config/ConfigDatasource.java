package com.samp.app.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

/**
 * @author yperez
 */
@Configuration
public class ConfigDatasource {

	public static final String DATASOURCE = "ds/datasource";

	@Bean(name=DATASOURCE)
	@ConfigurationProperties(prefix = "postgres.junit")
	@Primary
	public DataSource getDataSourceOperacional() {
		return new HikariDataSource();
	}
	
}
