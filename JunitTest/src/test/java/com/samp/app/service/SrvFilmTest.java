package com.samp.app.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.samp.app.mapper.MapperFilm;
import com.samp.app.model.FilmTO;

/**
 * @Author yperez
 */
@RunWith(SpringRunner.class)
public class SrvFilmTest{
	
	@TestConfiguration
	static class FilmServiceTestConfiguration{
		@Bean
		public SrvFilm srvFilm(){
			return new SrvFilm();
		}
	}
	
	@MockBean
	protected MapperFilm mapperFilm;
	
	@Autowired
	protected SrvFilm srvFilm;
	
	@Before
	public void setUp(){
		
		
		List<FilmTO> values = new ArrayList<>();
		
		FilmTO film = new FilmTO("Titanic");
		values.add(film );
		Mockito.when(mapperFilm.findAllMovies()).thenReturn(values );
		
		
	}
	
	
	@Test
	public void testFindAllMovies() {
		List<FilmTO> out = srvFilm.findAllMovies();
		assertNotNull(out);
		assertEquals(out.get(0).getCode(), "Titanic");
		
	}
}
