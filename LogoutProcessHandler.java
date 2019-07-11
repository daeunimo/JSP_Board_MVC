package com.ja.board.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutProcessHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		
		try {
			response.sendRedirect("./boardPage.do");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
