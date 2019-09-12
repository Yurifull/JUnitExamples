package com.samp.app.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import javax.inject.Named;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.samp.app.mapper.JunitMapper;

/**
 * @Author yperez
 */
@Configuration
@MapperScan(basePackages= "com.samp.app.mapper", sqlSessionFactoryRef="sessionFactory")
public class PrimaryDatasource {
	
	public static final String SESSION_FACTORY = "sessionFactory";
	
	@Bean(name = SESSION_FACTORY)
	@Primary
	public SqlSessionFactoryBean sqlSessionFactory(@Named(ConfigDatasource.DATASOURCE) final DataSource dataSourcePrevOpe) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSourcePrevOpe);
		SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBean.getObject();
		sqlSessionFactory.getConfiguration().addMapper(JunitMapper.class);
		return sqlSessionFactoryBean;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManagerOp(@Named(ConfigDatasource.DATASOURCE) final DataSource dataSourcePrevOpe) {
		return new DataSourceTransactionManager(dataSourcePrevOpe);
	}
	
	@Bean
	public MapperFactoryBean<JunitMapper> opMapper(@Named(SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryOpera) throws Exception{ 
		MapperFactoryBean<JunitMapper> factoryBean = new MapperFactoryBean<>(JunitMapper.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactoryOpera.getObject());
		return factoryBean;
	}
	
}
