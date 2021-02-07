package com.demo.common.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	private static Connection jdbcConnection = null;

	public static Connection getConnection() {
		if (jdbcConnection != null) {
			return jdbcConnection;
		} else {

			try {
				Properties properties = new Properties();
				InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");

				properties.load(inputStream);

				String dbDriver = properties.getProperty("dbDriver");
				String connectionUrl = properties.getProperty("connectionUrl");
				String userName = properties.getProperty("userName");
				String password = properties.getProperty("password");
				Class.forName(dbDriver).newInstance();
				jdbcConnection = DriverManager.getConnection(connectionUrl, userName, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return jdbcConnection;
		}
	}
	public static void close() {
		try {
			jdbcConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
