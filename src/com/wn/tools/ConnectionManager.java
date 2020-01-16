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
	// �õ�����Դ�����ӳصľ���ʵ�֣�
	private static DruidDataSource DATASOURCE;

	static {
		// java.util.Properties����ֱ�Ӵ�properties��ͨ����������á�ֵ��
		// Properties pro = new Properties();
		// jdbc.properties�ļ���·��
		// String path =
		// ConnectionManager.class.getClassLoader().getResource("/").getPath();
		// ����ı�����
		// File f = new File(path+"jdbc.properties");
		// System.out.println(f.exists());
		Properties pro = new Properties();
		try {
			// ����������
			// InputStream input = new FileInputStream(f);
			// ���ı�����תΪproperties����
			// pro.load(input);

			InputStream reader = new FileInputStream(new File("src" + File.separator + "jdbc.properties"));
			pro.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ��properties�е�������Ϣ������̬����
		DRIVERCLASSNAME = pro.getProperty("driverClassName");
		URL = pro.getProperty("url");
		USERNAME = pro.getProperty("userName");
		PASSWORD = pro.getProperty("password");
		MAXACTIVE = Integer.parseInt(pro.getProperty("maxActive"));
		MINIDLE = Integer.parseInt(pro.getProperty("minIdle"));
		MAXWAIT = Integer.parseInt(pro.getProperty("maxWait"));
		// ����
		DATASOURCE = new DruidDataSource();
		DATASOURCE.setDriverClassName(DRIVERCLASSNAME);
		DATASOURCE.setUrl(URL);
		DATASOURCE.setUsername(USERNAME);
		DATASOURCE.setPassword(PASSWORD);
		DATASOURCE.setMaxActive(MAXACTIVE);
		DATASOURCE.setMinIdle(MINIDLE);
		DATASOURCE.setMaxWait(MAXWAIT);

		// ����������ﵽ���޵Ĳ��ȴ�ʩ �������ӳ���ͼ���ճ�ʱ�����ӡ���λ���롣
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
