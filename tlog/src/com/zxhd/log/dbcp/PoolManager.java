package com.zxhd.log.dbcp;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.zxhd.log.util.AppConfig;

public class PoolManager {
	
	private static BasicDataSource dataSource;
	/**
	 * 初始化连接池
	 */
	public static void initConf(){
		String url = AppConfig.getString("dbUrl");
		String userName = AppConfig.getString("dbUserName");
		String password = AppConfig.getString("dbPassword");
		String driverClass = AppConfig.getString("dbDriverClass");
		String initialSize = AppConfig.getString("initialSize");
		String maxActive = AppConfig.getString("maxActive");//最大连接数
		String maxIdle = AppConfig.getString("maxIdle");//最大空闲连接
		String minIdle = AppConfig.getString("minIdle");//最小空闲连接
		String maxWait = AppConfig.getString("maxWait");//最大等待时间
		String defaultAutoCommit = AppConfig.getString("defaultAutoCommit");//是否自动事务，默认不启动
		String defaultReadOnly = AppConfig.getString("defaultReadOnly");//是否只读
		String defaultTransactionIsolation = AppConfig.getString("defaultTransactionIsolation");//数据库隔离界别
		
		Properties prop = new Properties();
		prop.setProperty("driverClassName", driverClass);
		prop.setProperty("url", url);
		prop.setProperty("username", userName);
		prop.setProperty("password", password);
		prop.setProperty("initialSize", initialSize);
		prop.setProperty("maxActive", maxActive);
		prop.setProperty("maxIdle", maxIdle);
		prop.setProperty("minIdle", minIdle);
		prop.setProperty("maxIdle", maxIdle);
		prop.setProperty("maxWait", maxWait);
		prop.setProperty("defaultAutoCommit", defaultAutoCommit);
		prop.setProperty("defaultReadOnly", defaultReadOnly);
		prop.setProperty("defaultTransactionIsolation", defaultTransactionIsolation);
		try {
			dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection(){
		try {
			System.out.println(dataSource.getNumActive());
			return dataSource.getConnection();
		} catch (SQLException e) {
			initConf();
			try {
				return dataSource.getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	
	
}
