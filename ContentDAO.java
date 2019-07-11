package com.ja.board.model.dao;

import com.ja.board.model.dto.*;
import java.sql.*;
import com.ja.board.model.*;
import java.util.*;

public class ContentDAO {
	public ArrayList<ContentDTO> selectAll() {
		ArrayList<ContentDTO> listContent = new ArrayList<ContentDTO>();
		
		Connection conn=JdbcUtil.getConnection();
		
		PreparedStatement pstmt = null;
		
		ResultSet rs=null;

		try {
			String query="SELECT * FROM Board_CONTENTS ORDER BY c_idx DESC";
			
			System.out.println("실행될 쿼리 : "+query);
			
			pstmt = conn.prepareStatement(query);
			
			rs=pstmt.executeQuery();
			
			//데이터 구성...로직...
			while(rs.next()) {
				ContentDTO contentDTO = new ContentDTO(rs.getString("c_idx"), rs.getString("m_idx"),
						rs.getString("c_title"),rs.getString("c_content"),rs.getString("c_count"),
						rs.getString("c_writedate"));
				
				listContent.add(contentDTO); //데이터 쌓기
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, pstmt, rs);
		
		return listContent;
	}

	public ContentDTO selectByIdx(String c_idx) {
		ContentDTO contentDTO = null;

		Connection conn=JdbcUtil.getConnection();
		
		PreparedStatement pstmt = null;
		
		ResultSet rs=null;

		try {
			String query="SELECT * FROM Board_CONTENTS WHERE c_idx=?";
			
			System.out.println("실행될 쿼리 : "+query);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,c_idx);
			
			rs=pstmt.executeQuery();
			
			//데이터 구성...로직...
			if(rs.next()) {
				contentDTO = new ContentDTO(rs.getString(1), rs.getString(2),
						rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6));
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, pstmt, rs);
		return contentDTO;
	}
	
	public void insert(String m_idx, String c_title, String c_content) {
		
		Connection conn=JdbcUtil.getConnection();
		
		PreparedStatement pstmt = null;
	

		try {
			String query="INSERT INTO BOARD_CONTENTS VALUES(BOARD_CONTENTS_Seq.nextval,?,?,?,0,SYSDATE)";
			
			System.out.println("실행될 쿼리 : "+query);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,m_idx);
			pstmt.setString(2,c_title);
			pstmt.setString(3,c_content);
			
			pstmt.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, pstmt, null);
		
	}
	
		public void deleteByIdx(String c_idx) {
			Connection conn=JdbcUtil.getConnection();
			
			PreparedStatement pstmt = null;

			try {
				String query="DELETE FROM BOARD_CONTENTS WHERE c_idx=?";
				
				System.out.println("실행될 쿼리 : "+query);
				
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,c_idx);
				
				pstmt.executeUpdate();			
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			JdbcUtil.close(conn, pstmt, null);
			
			
		}
		
		public void update(String c_idx, String c_title, String c_content) {
			
			Connection conn=JdbcUtil.getConnection();
			
			PreparedStatement pstmt = null;

			try {
				String query="UPDATE BOARD_CONTENTS SET c_title=?,c_content=? WHERE c_idx=?";
				
				System.out.println("실행될 쿼리 : "+query);
				
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,c_title);
				pstmt.setString(2,c_content);
				pstmt.setString(3,c_idx);
				
				
				pstmt.executeUpdate();			
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			JdbcUtil.close(conn, pstmt, null);
			
			
		}
}
