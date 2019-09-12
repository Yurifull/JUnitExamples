package com.samp.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.samp.app.configuration.AbstractTestController;

/**
 * @Author yperez
 */
public class FilmControllerTest extends AbstractTestController{
	
	 @Test
	 public void testListarBancosPagoInternet() throws Exception{
		 mvc.perform(
					get("/film/find-all")
		                 .contentType(MediaType.APPLICATION_JSON))
						 .andExpect(status().isOk());
	 }
	
}
