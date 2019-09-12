package com.samp.app.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@MapperScan("com.samp.core.services.mapper")
public class SAMPConfiguration {

    /**
     * username.
     */
    private String username;

    /**
     * password.
     */
    private String password;

    /**
     * url.
     */
    private String url;

    /**
     * Constructor por defecto.
     */
    public SAMPConfiguration() {
        super();
    }

    /**
     * Permite obtener el valor del atributo username.
     *
     * @return the username value.
     */
    public final String getUsername() {
        return this.username;
    }

    /**
     * Permite establecer el valor del atributo username.
     *
     * @param username new value for username attribute.
     */
    public final void setUsername(String username) {
        this.username = username;
    }

    /**
     * Permite obtener el valor del atributo password.
     *
     * @return the password value.
     */
    public final String getPassword() {
        return this.password;
    }

    /**
     * Permite establecer el valor del atributo password.
     *
     * @param password new value for password attribute.
     */
    public final void setPassword(String password) {
        this.password = password;
    }

    /**
     * Permite obtener el valor del atributo url.
     *
     * @return the url value.
     */
    public final String getUrl() {
        return this.url;
    }

    /**
     * Permite establecer el valor del atributo url.
     *
     * @param url new value for url attribute.
     */
    public final void setUrl(String url) {
        this.url = url;
    }

    /**
     * Metodo datasource.
     *
     * @return datasource.
     * @throws SQLException en caso de error.
     */
    @Bean(name = "dataSourcePorAdmin")
    @Primary
    public DataSource dataSourcePorAdmin() throws SQLException {
        
    	final PGSimpleDataSource  dataSource = new PGSimpleDataSource ();  
    	dataSource.setDatabaseName("org.postgresql.Driver");  
    	dataSource.setUrl(this.url);  
    	dataSource.setUser(this.username);  
    	dataSource.setPassword(this.password);
    	
        return dataSource;
    }

    /**
     * Metodo encagado de generar una fabrica de sessiones.
     *
     * @param dataSource Data Source a utilizar.
     * @return Fabrica de sessiones.
     * @throws Exception En caso de que exista un problema con la BD.
     */
    @Bean(name = "sqlSessionFactoryPorAdmin")
    @Primary
    public SqlSessionFactory sqlSessionFactoryPorAdmin(
        @Qualifier("dataSourcePorAdmin") DataSource dataSourcePorAdmin)
        throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSourcePorAdmin);
        return sessionFactory.getObject();
    }

    /**
     * Metodo encagado de generar el Template que utilizada MyBatis.
     *
     * @param sqlSessionFactory Fabrica de sessiones.
     * @return Template.
     */
    @Bean(name = "sqlSessionTemplatePorAdmin", destroyMethod = "clearCache")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactoryPorAdmin") SqlSessionFactory sqlSessionFactory) {
    	return  new SqlSessionTemplate(sqlSessionFactory);
    }

}