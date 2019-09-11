package com.samp.app.junittest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

/**
 * The Class JunitTestApplicationTests.
 * http://blog.rizvn.com/2018/04/testing-database-querries-with-embedded.html
 */
public class JunitTestApplicationTests extends AbstractTest{

//	private EmbeddedPostgres embeddedPostgres;
//
//	  @Before
//	  public void initialise() throws Exception{
//	    if(embeddedPostgres == null) {
//	      //Create an instance of embedded postgress
//	      embeddedPostgres = EmbeddedPostgres.builder()
//	                                         .setPort(5433).start();
//
////	      try (Connection conn = embeddedPostgres.getPostgresDatabase().getConnection()) {
////	        Statement statement = conn.createStatement();
//////	        statement.execute("CREATE DATABASE EXAMPLEDB");
////	        statement.execute("CREATE TABLE films (code char(5));");
////	        statement.execute("INSERT INTO films VALUES ('movie');");
////	        statement.execute("INSERT INTO films VALUES ('hello');");
////	      }
////	      
//	      
//	    		  
//	    }
//	  }
//	  
//	 
	   
	   @Test 
	   public void exampleTest(){
		   
	     try(Connection conn = dataSource.getConnection()){
	       Statement statement = conn.createStatement();
//	       statement.execute("CREATE TABLE films (code char(5));");
//	       statement.execute("INSERT INTO films VALUES ('movie');");
//	       statement.execute("INSERT INTO films VALUES ('hello');");
	       ResultSet resultset = statement.executeQuery("SELECT * FROM films");
	       
	       while (resultset.next()) {              
	    	    System.out.println(resultset.getString("code"));
	    	}
	       
	       
	     }
	     catch (Exception ex){
	       System.out.println(ex);
	     }
	   }
	   
}
