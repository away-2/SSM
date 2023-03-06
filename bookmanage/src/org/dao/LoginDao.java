package org.dao;
import java.sql.*;
import org.model.*;
import org.db.*;
public class LoginDao {
	Connection conn;								//数据库连接对象
	public Login checkLogin(String sname, String password){	//验证登录用户名和密码
try{
			conn = DBconn.getConn();				//获取连接对象
			String sql="select * from [login] where sname='"+sname+"' and password='"+password+"'";
			Statement stat=conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);	//执行查询，返回结果集
			if(rs.next()){					//返回结果不为空，表示有此用户信息
				Login login = new Login();	//通过JavaBean对象保存值
				login.setSname(rs.getString(1));
				login.setPassword(rs.getString(2));
				login.setRole(rs.getInt(3));
				return login;					//返回已经设值的JavaBean对象
			}
			return null;					//无此用户，验证失败，返回null
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBconn.CloseConn();					//关闭连接
		}
	}
}