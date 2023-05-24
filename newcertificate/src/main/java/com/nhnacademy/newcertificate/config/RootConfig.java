package com.nhnacademy.newcertificate.config;

import com.nhnacademy.newcertificate.Base;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Base.class)
public class RootConfig {
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://133.186.144.236:3306/nhn_academy_13");
        dataSource.setUsername("nhn_academy_13");
        dataSource.setPassword("EOcV(baaATcu3lny");

        dataSource.setInitialSize(10);
        dataSource.setMaxTotal(10);
        dataSource.setMinIdle(10);
        dataSource.setMaxIdle(10);

        dataSource.setMaxWaitMillis(1000);

        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);

        return dataSource;
    }

//    @Bean
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jh-server.mysql.database.azure.com");
//        dataSource.setUsername("mysqladmin");
//        dataSource.setPassword("1q2w3e4r5t6y7u8i9o0p!!");
//
//        dataSource.setInitialSize(10);
//        dataSource.setMaxTotal(10);
//        dataSource.setMinIdle(10);
//        dataSource.setMaxIdle(10);
//
//        dataSource.setMaxWaitMillis(1000);
//
//        dataSource.setTestOnBorrow(true);
//        dataSource.setTestOnReturn(true);
//        dataSource.setTestWhileIdle(true);
//
//        return dataSource;
//    }

}
