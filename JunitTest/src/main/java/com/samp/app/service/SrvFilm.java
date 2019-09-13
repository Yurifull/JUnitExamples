package com.samp.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samp.app.mapper.MapperFilm;
import com.samp.app.model.FilmTO;

/**
 * @Author yperez
 */
@Service
public class SrvFilm {

	@Autowired
	private MapperFilm mapperFilm;
	
	public List<FilmTO> findAllMovies() {
		return mapperFilm.findAllMovies();
	}
	
	
}
