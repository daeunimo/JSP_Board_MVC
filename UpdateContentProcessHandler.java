package com.ja.board.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.board.model.dao.*;

public class UpdateContentProcessHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String c_idx=request.getParameter("c_idx");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		new ContentDAO().update(c_idx, title, content);
		
		try {
		response.sendRedirect("./boardPage.do");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
