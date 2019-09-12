package com.samp.app.junittest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.samp.app.configuration.AbstractDatabaseTest;
import com.samp.app.service.SrvFilm;

/**
 * The Class JunitTestApplicationTests.
 * http://blog.rizvn.com/2018/04/testing-database-querries-with-embedded.html
 */
public class SrvFilmTest extends AbstractDatabaseTest {

	
	@Autowired
	private SrvFilm srvFilm;
	
	   
	@Test 
	public void exampleTest(){
		
		
		System.out.println(srvFilm.findAllMovies());
		
		
		try(Connection conn = dataSource.getConnection()){
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT * FROM junit.films");
			
			while (resultset.next()) {              
				System.out.println(resultset.getString("code"));
			}
			
		}
		catch (Exception ex){
			System.out.println(ex);
		}
	}
	
}
