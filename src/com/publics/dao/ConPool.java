package com.publics.dao;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;

public class ConPool {
	public static BasicDataSource dataSource=null;
	static {
		dataSource =new BasicDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=repast");
		dataSource.setUsername("sa");
		dataSource.setPassword("123456");
		
	}
	public Connection getConnection(){
		try {
			if(dataSource!=null){
				return dataSource.getConnection();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}return null;
	}
	public void close(){
		try {
				dataSource.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
