package com.ja.board.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.board.model.dao.*;
import com.ja.board.model.vo.*;

public class WriteContentProcessHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		SessionDataVo sessionVo= (SessionDataVo) request.getSession().getAttribute("sessionData"); //attribute(객체_)
		String sessionIdx=sessionVo.getSessionIdx();
		
		ContentDAO contentDAO= new ContentDAO();
		contentDAO.insert(sessionIdx, title, content);
		
		try {
			response.sendRedirect("./boardPage.do");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
