package com.ja.board.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.board.model.dao.*;
import com.ja.board.model.dto.*;
import com.ja.board.model.vo.*;

public class LoginProcessHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		String viewPage=null;
		

		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberDAO.selectByid(id);
		
		if(memberDTO !=null && memberDTO.getM_pw().equals(pw)) {
			//로그인 성공
			
			SessionDataVo sessionDataVo= new SessionDataVo(memberDTO.getM_idx(),memberDTO.getM_nick());
			
			request.getSession().setAttribute("sessionData", sessionDataVo);
			
			try {
			response.sendRedirect("./boardPage.do");
			}catch(Exception e) {
				e.printStackTrace();

			}
		} else {
			viewPage="/WEB-INF/viewer/loginFail.jsp";
		}
		
		return viewPage;
	}

}
