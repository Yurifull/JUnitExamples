package com.samp.app.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import com.samp.app.config.ConfigDatasource;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Class for started database postgres session.
 * 
 * https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html#boot-features-testing-spring-boot-applications-testing-autoconfigured-tests
 * 
 * https://github.com/flapdoodle-oss/de.flapdoodle.embed.process
 * @Author yperez
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class AbstractDatabaseTest {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractDatabaseTest.class);
	
	protected static EmbeddedPostgres embeddedPostgres;
	
	protected static DataSource dataSource;
	
	@BeforeClass
	public static void beforeClass() throws IOException, SQLException {
	
		LOGGER.info("Starting embedded PostgreSQL on port 5433. Please wait...");
		embeddedPostgres = EmbeddedPostgres.builder().setPort(5433).start();
		
		dataSource = EmbeddedPostgres.builder().start().getPostgresDatabase();
		
		LOGGER.info("LOAD DATA FROM FILE");
		loadData();
		LOGGER.info("Embedded PostgreSQL started.");
	}
	
	
	@TestConfiguration
	static class AbstractTestConfiguration{
		
		@Bean(name=ConfigDatasource.DATASOURCE)
		@Primary
		public DataSource getDataSourceOperacional() {
			HikariDataSource hikary = new HikariDataSource();
			hikary.setDataSource(dataSource);
			return hikary;
		}
		
	}
	

	private static void loadData() throws SQLException, IOException {
		
		String s = new String();
	    StringBuilder sb = new StringBuilder();
		FileReader fr = new FileReader(new File("D:\\POC\\JUnitExamples\\JunitTest\\src\\test\\resources\\import.sql"));
		BufferedReader br = new BufferedReader(fr);
		while((s = br.readLine()) != null){
            sb.append(s);
        }
        br.close();
		
        String[] sentences = sb.toString().split(";");
        
        for(int i=0 ; i < sentences.length; i++){
        	try (Connection conn = dataSource.getConnection()) {
        		Statement statement = conn.createStatement();
        		LOGGER.info("**********EXECUTE***********");
        		LOGGER.info(sentences[i]);
        		statement.execute(sentences[i]+";");
        	}        	
        }
        
	}
	
	
    
}
