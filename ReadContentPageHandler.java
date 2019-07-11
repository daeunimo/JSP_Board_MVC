package com.ja.board.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.board.model.dao.*;
import com.ja.board.model.dto.*;
import com.ja.board.model.vo.*;

public class ReadContentPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String c_idx=request.getParameter("c_idx");
		
		ContentDAO contentDAO = new ContentDAO(); //객체 생성
		ContentDTO contentDTO = contentDAO.selectByIdx(c_idx);
		
		String content = contentDTO.getC_content();
		content=content.replace("\n", "<br>"); 
		contentDTO.setC_content(content); //바꾼 내용을 다시 넣어주기
		
		MemberDAO memberDAO = new MemberDAO();
		memberDAO.selectByIdx(contentDTO.getM_idx());

		MemberDTO memberDTO = memberDAO.selectByIdx(contentDTO.getM_idx());
		
		ContentData contentData = new ContentData(contentDTO, memberDTO);
		
		request.setAttribute("contentData", contentData);
		
		return "/WEB-INF/viewer/readContentPage.jsp"; // 문자열 리턴 -> 서블릿에서 포워딩
	}

}
