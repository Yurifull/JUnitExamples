package com.samp.app.junittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.samp.app.configuration.AbstractDatabaseTest;
import com.samp.app.model.FilmTO;
import com.samp.app.service.SrvFilm;

/**
 * The Class JunitTestApplicationTests.
 * http://blog.rizvn.com/2018/04/testing-database-querries-with-embedded.html
 */
public class SrvFilmTest extends AbstractDatabaseTest {

	@TestConfiguration
	static class AbstractTestConfiguration{
		
		public static final String DATASOURCE = "ds/datasource";
		
		@Bean(name=DATASOURCE)
		@ConfigurationProperties(prefix = "postgres.junit")
		public DataSource getDataSourceOperacional() {
			return dataSource;
		}
		
	}
	
	@Autowired
	private SrvFilm srvFilm;
	
	   
	@Test 
	public void exampleTest(){
		
		LOGGER.info("INIT CALL PROCEDURE");
		List<FilmTO> out = srvFilm.findAllMovies();
		
		assertNotNull(out);
		assertEquals(out.size(), 10);
	}
	
}
