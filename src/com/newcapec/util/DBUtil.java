package com.newcapec.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBUtil {
	
	public static void main(String []args){
		if(DBUtil.conn()!=null){
		System.out.println("脸上干了，嗯");	
		}
	}
	
	
	
	public static Connection conn(){
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bbs";
		String user = "root";
		String password = "123456";
		try{
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url,user,password);
			System.out.println("连上了");
		}catch(Exception e){
			
		}
		return conn;
		
	}
	
	public static void close(PreparedStatement pstm,Connection conn){
		if(pstm!=null){
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try{
				conn.close();
			}catch(Exception e){
				
			}
		}
	}

}
