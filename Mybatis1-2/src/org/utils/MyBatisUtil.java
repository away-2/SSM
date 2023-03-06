package org.utils;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
private static SqlSessionFactory factory;
static{
	{ try{
		String resource = "mybatis-config.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(stream);
		} catch(Exception e) {
		e.printStackTrace();
	}
}
}
//创建session对象
	public static SqlSession CreateSession() {
	   return factory.openSession(false);	
	}
//关闭session方法
public static void CloseSession(SqlSession session){
	if(session != null) {
		session.close();						//关闭SqlSession
	}
}
	
}

