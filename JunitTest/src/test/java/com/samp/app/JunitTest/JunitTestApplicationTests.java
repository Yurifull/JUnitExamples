package com.samp.app.JunitTest;

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
 * https://github.com/yandex-qatools/postgresql-embedded
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@TestPropertySource("classpath:application-test.properties")
public class JunitTestApplicationTests {

	private EmbeddedPostgres embeddedPostgres;

	  @Before
	  public void initialise() throws Exception{
	    if(embeddedPostgres == null) {
	      //Create an instance of embedded postgress
	      embeddedPostgres = EmbeddedPostgres.builder()
	                                         .setPort(5433).start();

	      try (Connection conn = embeddedPostgres.getPostgresDatabase().getConnection()) {
	        Statement statement = conn.createStatement();
//	        statement.execute("CREATE DATABASE EXAMPLEDB");
	        statement.execute("CREATE TABLE films (code char(5));");
	        statement.execute("INSERT INTO films VALUES ('movie');");
	        statement.execute("INSERT INTO films VALUES ('hello');");
	      }
	      
	      dataSource = embeddedPostgres.builder().start().getPostgresDatabase();
	    		  
	    }
	  }
	  
//	private Connection conn;
//	
//	import java.io.IOException;
//	import java.sql.Connection;
//	import java.sql.DriverManager;
//	import java.sql.SQLException;
//	import java.sql.Statement;
//	
//	import org.junit.Before;
//	import org.junit.Test;
//	
//	import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;
//	import ru.yandex.qatools.embed.postgresql.distribution.Version;
//	private EmbeddedPostgres postgres;
//	
//	@Before
//	public void setup() throws IOException, SQLException{
//		// starting Postgres
//		postgres = new EmbeddedPostgres(Version.V9_6_8);
//		
//		String url = postgres.start("localhost", 5432, "TEST", "userName", "password");
//		
//		conn = DriverManager.getConnection(url);
//		conn.createStatement().execute("CREATE TABLE films (code char(5));");
//		conn.createStatement().execute("INSERT INTO films VALUES ('movie');");
//		
//	}
//	
//	
//	@Test
//	public void contextLoads() throws SQLException {
//		
//		Statement statement = conn.createStatement();
//		
//		System.out.println("OUTPUT"+statement.execute("SELECT * FROM films;"));
//		System.out.println("OUTPUT"+statement.getResultSet().getString("code"));
//		
//		// close db connection
//		conn.close();
//		// stop Postgres
//		postgres.stop();
//		
//	}

	  DataSource dataSource;
	   
	   @Test 
	   public void exampleTest(){
	     try(Connection conn = dataSource.getConnection()){
	       Statement statement = conn.createStatement();
	       statement.execute("CREATE TABLE films (code char(5));");
	       statement.execute("INSERT INTO films VALUES ('movie');");
	       statement.execute("INSERT INTO films VALUES ('hello');");
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
