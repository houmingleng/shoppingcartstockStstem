package com.uplooking.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisFactory {
	//��������
	private static SqlSessionFactory factory=null;
	
	//��̬��
	static{
		try {
			InputStream in = Resources.getResourceAsStream("mybatis.cfg.xml");		//IO������xml
			factory = new SqlSessionFactoryBuilder().build(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//��ʼ�Ự
	public static SqlSession getsqlsession(){
		return factory.openSession(false);			
	}
	
	//�رջỰ
	public static void close(SqlSession sqlsession){
		if(sqlsession!=null){
			sqlsession.close();
		}
	}
	
	
	
	
	
}
