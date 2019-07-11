package com.ja.board.model.dao;
//데이터 연동 클래스  _데이터베이스의 data에 접근하기 위한 객체
import com.ja.board.model.dto.*;
import com.ja.board.model.*;
import java.sql.*;

public class MemberDAO {
	public void insert(String m_id,String m_pw,String m_nick, String m_phone, String m_address ) {
		Connection conn=JdbcUtil.getConnection();
		
		PreparedStatement pstmt = null;
		
		try {
			String query="INSERT INTO Board_Members VALUES(Board_Members_seq.nextval,?,?,?,?,?,SYSDATE)";
			
			System.out.println("실행될 쿼리 : "+query);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);
			pstmt.setString(3, m_nick);
			pstmt.setString(4, m_phone);
			pstmt.setString(5, m_address);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, pstmt, null);
	}
	
	
	public MemberDTO selectByIdx(String m_idx) {
		MemberDTO memberDTO= null;
		
		Connection conn=JdbcUtil.getConnection();
		
		PreparedStatement pstmt = null;
		
		ResultSet rs=null;
		
		try {
			String query="SELECT * FROM Board_Members WHERE m_idx=?";
			
			System.out.println("실행될 쿼리 : "+query);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m_idx);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				memberDTO = new MemberDTO(rs.getString("m_idx"), rs.getString("m_id"),
						rs.getString("m_pw"),rs.getString("m_nick"),rs.getString("m_phone"),
								rs.getString("m_address"),rs.getString("m_joindate"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, pstmt, rs);
		
		return memberDTO;
	}
	
	public MemberDTO selectByid(String m_id) {
		
		MemberDTO memberDTO= null;
		
		Connection conn=JdbcUtil.getConnection();
		
		PreparedStatement pstmt = null;
		
		ResultSet rs=null;

		try {
			String query="SELECT * FROM Board_Members WHERE m_id=?";
			
			System.out.println("실행될 쿼리 : "+query);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m_id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				memberDTO = new MemberDTO(rs.getString("m_idx"), rs.getString("m_id"),
						rs.getString("m_pw"),rs.getString("m_nick"),rs.getString("m_phone"),
								rs.getString("m_address"),rs.getString("m_joindate"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, pstmt, rs);
		
		return memberDTO;
	}
}
