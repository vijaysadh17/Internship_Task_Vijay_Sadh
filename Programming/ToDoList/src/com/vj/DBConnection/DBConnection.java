package com.vj.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection implements DBConfig {
	static Connection con;

	public static Connection getConn() {

		try {
			Class.forName(Driver);
			con = DriverManager.getConnection(Connection, Username, Password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
