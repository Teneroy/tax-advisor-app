package org.leonid.taxadviserapp.dao.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.leonid.taxadviserapp")
public class SpringJdbcConfig {
    @Value("${dblogin}")
    private String login;

    @Value("${dbname}")
    private String name;

    @Value("${dbpassword}")
    private String password;

    @Value("${dbport}")
    private String port;

    @Value("${dbhost}")
    private String host;

    @Value("${dbdriver}")
    private String driver;

    @Value("${sqltype}")
    private String type;

    @Bean
    DataSource dataSource() {
        BasicDataSource dataSourceConfig = new BasicDataSource();
        dataSourceConfig.setDriverClassName(driver);
        dataSourceConfig.setUrl("jdbc:" + type + "://" + host + ":" + port + "/" + name);
        dataSourceConfig.setUsername(login);
        dataSourceConfig.setValidationQuery("SELECT 1");
        dataSourceConfig.setPassword(password);

        return dataSourceConfig;
    }

}
