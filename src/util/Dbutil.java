package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//该工具类Dbutil是用于与数据库建立连接的
public class Dbutil {

	private String dbUrl="jdbc:mysql://localhost:3306/db_student?useSSL=false&useUnicode=true&characterEncoding=utf-8";
	private String dbUserName="root";
	private String dbPassword="ljy154..";
	private String jdbcName="com.mysql.jdbc.Driver";//驱动名称

	//定义一个获取数据库连接的方法getCon()
	public Connection getCon(){
		try{
			Class.forName(jdbcName);//加载数据库驱动
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		Connection con = null;//创建一个连接对象
		try{
			con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//获取连接对象
		}catch (SQLException e){
			e.printStackTrace();
		}
		return con;
	}
}
