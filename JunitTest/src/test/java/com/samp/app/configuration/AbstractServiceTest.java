package com.samp.app.configuration;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.samp.app.mapper.MapperFilm;
import com.samp.app.service.SrvFilm;

/**
 * @Author yperez
 */
@RunWith(SpringRunner.class)
public class AbstractServiceTest {
	
	@TestConfiguration
	static class FilmServiceTestConfiguration{
		@Bean
		public SrvFilm srvFilm(){
			return new SrvFilm();
		}
	}
	
	@MockBean
	private MapperFilm mapperFilm;
	
}
