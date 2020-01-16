package com.wn.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class ConnectionManager {
	private static final String DRIVERCLASSNAME;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;
	private static final int MAXACTIVE;
	private static final int MINIDLE;
	private static final int MAXWAIT;
	// 得到数据源（连接池的具体实现）
	private static DruidDataSource DATASOURCE;

	static {
		// java.util.Properties可以直接从properties中通过“键”获得“值”
		// Properties pro = new Properties();
		// jdbc.properties文件的路径
		// String path =
		// ConnectionManager.class.getClassLoader().getResource("/").getPath();
		// 获得文本对象
		// File f = new File(path+"jdbc.properties");
		// System.out.println(f.exists());
		Properties pro = new Properties();
		try {
			// 创建输入流
			// InputStream input = new FileInputStream(f);
			// 将文本内容转为properties对象
			// pro.load(input);

			InputStream reader = new FileInputStream(new File("src" + File.separator + "jdbc.properties"));
			pro.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 将properties中的配置信息赋给静态常量
		DRIVERCLASSNAME = pro.getProperty("driverClassName");
		URL = pro.getProperty("url");
		USERNAME = pro.getProperty("userName");
		PASSWORD = pro.getProperty("password");
		MAXACTIVE = Integer.parseInt(pro.getProperty("maxActive"));
		MINIDLE = Integer.parseInt(pro.getProperty("minIdle"));
		MAXWAIT = Integer.parseInt(pro.getProperty("maxWait"));
		// 配置
		DATASOURCE = new DruidDataSource();
		DATASOURCE.setDriverClassName(DRIVERCLASSNAME);
		DATASOURCE.setUrl(URL);
		DATASOURCE.setUsername(USERNAME);
		DATASOURCE.setPassword(PASSWORD);
		DATASOURCE.setMaxActive(MAXACTIVE);
		DATASOURCE.setMinIdle(MINIDLE);
		DATASOURCE.setMaxWait(MAXWAIT);

		// 活动连接数量达到上限的补救措施 ，让连接池视图回收超时的连接。单位：秒。
		DATASOURCE.setRemoveAbandonedTimeout(3);
		DATASOURCE.setRemoveAbandoned(true);
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DATASOURCE.getConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
