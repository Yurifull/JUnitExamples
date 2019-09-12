package com.samp.app.model;

import java.io.Serializable;

/**
 * @Author yperez
 */
public class FilmTO implements Serializable{

	private static final long serialVersionUID = 7673327032416918910L;
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
