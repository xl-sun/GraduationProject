package qztc.sxl.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
	private static String user;
	private static String password;
	private static String url;
	static {
		try {
			InputStream is = DBConnection.class.getClassLoader().getResourceAsStream("/db.properties");
			Properties props = new Properties();
			props.load(is);
			url = props.getProperty("mysql.url");
			user = props.getProperty("mysql.user");
			password = props.getProperty("mysql.password");
			// ע������
			Class.forName(props.getProperty("mysql.driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�Ҳ�������");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("����properites�ļ�����");
		}
	}
	
	// ��ȡ����
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(url, user, password);
	}
	

	// �ر������н����(select)
	public static void close(ResultSet rs, Statement stat, Connection conn)
			throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (stat != null) {
			stat.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	// �ر������޽����(delete update insert)
	public static void close(Statement stat, Connection conn) throws Exception {
		if (stat != null) {
			stat.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}

