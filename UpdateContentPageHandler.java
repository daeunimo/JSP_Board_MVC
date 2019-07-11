package com.ja.board.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.board.model.dao.*;
import com.ja.board.model.dto.*;

public class UpdateContentPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String c_idx=request.getParameter("c_idx");
		
		ContentDTO contentDTO = new ContentDAO().selectByIdx(c_idx); //한 코드에 쓰기
		
		request.setAttribute("contentDTO", contentDTO);
		
		
		
		return "/WEB-INF/viewer/UpdateContentPage.jsp";
	}

}
