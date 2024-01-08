package com.khit.todoweb.unit_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j //로그(기록)를 출력하는 라이브러리.
public class JdbcTest {
	
	@Test //main 매서드 처럼 실행됨
	public void testConnection() {
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/springdb?serverTime=Asia/Seoul";
		String username="springuser";
		String password="pwspring";
		
		try {
			Class.forName(className);
			Connection conn = DriverManager.getConnection(url, username, password);
			//System.out.println("DB 연결 객체 생성: " + conn);
			log.info("DB연결 객체 생성: " + conn);
			
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
