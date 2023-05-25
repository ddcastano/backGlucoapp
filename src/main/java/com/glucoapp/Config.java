package com.glucoapp;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Config {
	public DataSource conexion() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/glucoapp");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("");
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return driverManagerDataSource;
    }
}
