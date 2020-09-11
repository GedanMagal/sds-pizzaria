package br.com.smartpizza.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan({ "br.com.smartpizza.*" })
@EnableWebMvc
@PropertySource("classpath:/resources/application.properties")
public class SpringConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private Environment env;

	@Bean
	public DataSource getDataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(env.getRequiredProperty("datasource.driver"));
		config.setJdbcUrl(env.getRequiredProperty("datasource.url"));
		config.setUsername(env.getRequiredProperty("datasource.username"));
		config.setPassword(env.getRequiredProperty("datasource.password"));
		
		HikariDataSource datasource = new HikariDataSource(config);
		return datasource;
	}
	private Properties getHiProperties() {
		Properties prop = new Properties();
		prop.put(AvailableSettings.DIALECT,env.getRequiredProperty( "hibernate.dialect"));
		prop.put(AvailableSettings.SHOW_SQL, env.getRequiredProperty("hibernate.show_sql"));
		prop.put(AvailableSettings.HBM2DDL_AUTO, env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return prop;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] {"br.com.smartpizza"});
		sessionFactory.setHibernateProperties(getHiProperties());
		return sessionFactory;
	}
}
