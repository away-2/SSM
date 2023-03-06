<%@ page language="java" pageEncoding="gb2312" import="org.model.Login"%>
<html>
<head>
	<title>欢迎使用</title>
</head>
<body>
	<%
	Login login=(Login)session.getAttribute("login");	
	//从会话中取出 Login 类型的对象“login”
	String lgn=login.getSname();	
	//获取对象login的sname属性值
	%>
	<%=lgn%>，您好！欢迎使用图书管理系统。
</body>
</html>
