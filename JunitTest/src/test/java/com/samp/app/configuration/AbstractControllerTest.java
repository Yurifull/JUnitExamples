package com.samp.app.configuration;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.samp.app.controller.FilmController;
import com.samp.app.service.SrvFilm;


/**
 * @Author yperez
 */
@RunWith(SpringRunner.class)
@WebMvcTest(
		{
			FilmController.class
		})
public class AbstractControllerTest {
	
	@MockBean
	protected SrvFilm srvFilm;
	
	protected MockMvc mvc;
	
	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	
	@Before
	public void setUp(){
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
}
