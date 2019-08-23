package com.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DBUtils {
	private static String url = "jdbc:mysql://localhost:3306/ssm?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8";// "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String user = "root";
	private static String psw = "root";

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	// 静态代码块 类加载的时候执行
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private DBUtils() {

	}

	/**
	 * 获取数据库的连接
	 * 
	 * @return conn
	 */
	public static Connection getConnection() {
		if (null == conn) {
			try {
				conn = DriverManager.getConnection(url, user, psw);
				System.out.println("连接成功！");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return conn;
	}

	/**
	 * 释放资源
	 * 
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public static void closeResources(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				if (null != pstmt) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					} finally {
						if (null != conn) {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
								throw new RuntimeException(e);
							}
						}
					}
				}
			}
		}
	}
}
