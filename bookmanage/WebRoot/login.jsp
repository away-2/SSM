<%@ page language="java" pageEncoding="gb2312"%>
<html>
<head>
	<title>ͼ�����ϵͳ</title>
</head>

<form action="loginServlet" method="post">
	<table valign="center" >
		<caption>�û���¼</caption>
		<tr>
			<td>��¼��</td>
			<td><input name="sname"type="text"size="20"/></td>
		</tr>
		<tr>
			<td>����</td>
			<td><input name="password"type="password"size="21"/></td>
		</tr>
	</table>
	<input type="submit"value="��¼"/>
	<input type="reset"value="����"/>
</form>

</body>
</html>