package com.pluralsight.conferencedemo.config;



import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {
    
    // @Bean
    // public DataSource dataSource() {
    //     // Builder pattern
    //     DataSourceBuilder builder = DataSourceBuilder.create();
    //     builder.url("jdbc:postgresql://localhost:5432/conference_app");
    //     builder.username("postgres");
    //     builder.password("200799");
    //     System.out.println("My custom datasource bean has been initialized and set");
    //     return builder.build();
    // }
}
