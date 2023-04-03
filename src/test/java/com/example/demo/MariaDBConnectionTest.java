package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class) => Junit4 사용시 추가, Junit5 사용시 생략.
@RunWith(SpringRunner.class)
@SpringBootTest
public class MariaDBConnectionTest {
	
	   
	    //application.properties 파일의 환경설정 내용을 가져오는 방법
	    //@Value(${})
	    @Value("${spring.datasource.driver-class-name}")
	    private String propertiesDRIVER;
	    
	    
	
	    // MariaDB 접속 설정
		static final String DRIVER = "org.mariadb.jdbc.Driver";
		static final String URL = "jdbc:mariadb://127.0.0.1:3306/study?serverTimezone=Asia/Seoul&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true";
		static final String USERNAME ="root";
		static final String PASSWORD="badboy5604";
	
		// Postgre 접속 설정
		//static final String DRIVER = "org.mariadb.jdbc.Driver";
		//static final String URL = "jdbc:postgresql://192.168.200.111:5432/testdb";
		//static final String USERNAME = "postgres";
		//static final String PASSWORD="admin";
		
	    @Test
	    public void getMySQLConnectionTest() {
	    	
	    	System.out.println("application properties : " + propertiesDRIVER);
	        
	        Connection conn = null;
	        Statement stmt = null;
	        
	        try {
	            
	            System.out.println("==================== Maria DB Connection START ====================");
	            
	            Class.forName(DRIVER);
	            
	            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            stmt = conn.createStatement();
	 
	            String sql = "select id, name, phone from test";
	 
	            ResultSet rs = stmt.executeQuery(sql);
	            while (rs.next()) {
	                
	                String userId = rs.getString("id");
	                String uuserName = rs.getString("name");
	                String userphone = rs.getString("phone");
	 
	                System.out.println("ID : " + userId);
	                System.out.println("USERNAME : " + uuserName);
	                System.out.println("phone: " + userphone);
	            }
	 
	            rs.close();
	            stmt.close();
	            conn.close();
	 
	        } catch (SQLException se1) {
	            se1.printStackTrace();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
	        
	        System.out.println("==================== Maria DB Connection END ====================");
	    }

}
