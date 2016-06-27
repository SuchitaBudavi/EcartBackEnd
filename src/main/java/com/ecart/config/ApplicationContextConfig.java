package com.ecart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.ecart.dao.ProductDao;
import com.ecart.dao.ProductDaoImpl;
import com.ecart.dao.UserDao;
import com.ecart.dao.UserDaoImpl;
import com.ecart.model.Product;
import com.ecart.model.User;


@Configuration
@EnableTransactionManagement
public class ApplicationContextConfig {
	

    
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("org.h2.Driver");
    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
    	dataSource.setUsername("sa");
    	dataSource.setPassword("");
    	System.out.println("dataSource");
    	return dataSource;
    }
    
    
    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	properties. put("hibernate.hbm2ddl.auto","update");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(Product.class);
    	sessionBuilder.addAnnotatedClasses(User.class);
    	System.out.println("inside sessionFactory");
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
    
    @Autowired
    @Bean
    public ProductDao getProductDao(SessionFactory sessionFactory) {
    	System.out.println("Applicationconfig productDao bean");
    	return new ProductDaoImpl(sessionFactory);
    }

    
    @Autowired
    @Bean
    public UserDao getUserDao(SessionFactory sessionFactory) {
    	System.out.println("Applicationconfig productDao bean");
    	return new UserDaoImpl(sessionFactory);
    }
}
