<%@ page language="java" pageEncoding="gb2312" import="org.model.Login"%>
<html>
<head>
	<title>��ӭʹ��</title>
</head>
<body>
	<%
	Login login=(Login)session.getAttribute("login");	
	//�ӻỰ��ȡ�� Login ���͵Ķ���login��
	String lgn=login.getSname();	
	//��ȡ����login��sname����ֵ
	%>
	<%=lgn%>�����ã���ӭʹ��ͼ�����ϵͳ��
</body>
</html>
