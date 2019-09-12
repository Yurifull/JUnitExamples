package com.samp.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.samp.app.model.FilmTO;

@Mapper
@JunitMapper
public interface MapperFilm {
	
	@Select(value="{CALL findallmovies()}")
	@Options(statementType = StatementType.CALLABLE)
	@Results({
		@Result(property="code", column="code")
	})
	public List<FilmTO> findAllMovies();
	
}
