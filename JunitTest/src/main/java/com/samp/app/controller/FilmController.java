package com.samp.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samp.app.model.FilmTO;
import com.samp.app.service.SrvFilm;

@RestController
@RequestMapping(value="film")
public class FilmController{

	protected static final Logger LOGGER = LoggerFactory.getLogger(FilmController.class);
	
	@Autowired
	private SrvFilm srvFilm;
	
	@GetMapping(value="/find-all", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FilmTO>> findAll() {
		LOGGER.info("init Film-findAll");
		return new ResponseEntity<>(srvFilm.findAllMovies(), null, HttpStatus.OK);
	}
}
