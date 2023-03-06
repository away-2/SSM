package org.servlet;
import javax.servlet.* ;
import javax.servlet.http.*;
import java.io.*;
import org.dao.*;
import org.model.*;

public class LoginServlet extends HttpServlet {
		
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");		//设置请求编码
		//该类为项目与数据的接口（DAO接口），用于处理数据与数据库表的一些操作
		LoginDao loginDao = new LoginDao();
		String a=request.getParameter("sname");
		String b=request.getParameter("password");
		Login l = loginDao.checkLogin(a,b);
		if(l!=null){			//如果登录成功
			HttpSession session = request.getSession();	//获得会话，用来保存当前登录用户的信息
		session.setAttribute("login", l);//把获取的对象保存在 Session 中
response.sendRedirect("main.jsp");//验证成功跳转到欢迎主页 main.jsp
			}else{
response.sendRedirect("error.jsp");	//验证失败跳转到错误处理页 error.jsp
		
		}
	}
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
		doPost(request,response);
	}
}