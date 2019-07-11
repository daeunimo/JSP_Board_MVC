package com.ja.board.model;

import java.sql.*;

public class JdbcUtil {
	 public static Connection getConnection() {
		 Connection conn=null;
		 
		 try {
			 conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:oracleDBCP");
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return conn;
	 }
	 
	 public static void close(Connection conn,PreparedStatement pstmt, ResultSet rs) {
		 try { // 모두 따로 예외처리하는 이유는 ... 앞에서 하나가 예외가 나오면 다른 것들을 종료시키지 않고 try문을 빠져나가기 때문에
			 if(rs!=null) {
				 rs.close();
			 }
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 try {
			 if(pstmt!=null) {
				 pstmt.close();
			 }
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 try {
			 
				 conn.close();
			 
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		 
	 }
}

