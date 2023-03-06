package org.db;
import java.sql.*; //数据库连接包：实现JDBC的类库
public class DBconn{
	public static Connection conn;
//成员变量为Connection类型的对象，且为类变量，
//所有DBConn类型的对象共享conn,无需独立赋值
	//获取数据库连接
	public static Connection getConn(){
		try {
			/**加载并注册 SQLServer 2008/2012 的 JDBC 驱动*/
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/**编写连接字符串，创建并获取连接 */
			//conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=MBOOK","sa","123");
//			conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\test;databaseName=MBOOK","sa","123");
			 Class.forName("com.mysql.jdbc.Driver");
			 String url="jbdc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
			 Connection conn=DriverManager.getConnection(url,"root","Shu520...");
			return conn;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public static void CloseConn(){//关闭连接
			try{
				conn.close();				//关闭连接
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
