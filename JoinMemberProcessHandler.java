package com.ja.board.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.board.model.dao.*;

public class JoinMemberProcessHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String nick=request.getParameter("nick");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");

		MemberDAO memberDAO = new MemberDAO();
		memberDAO.insert(id, pw, nick, phone, address);
		
		return "/WEB-INF/viewer/completeJoinMember.jsp"; //포워딩
	}

}
