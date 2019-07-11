package com.ja.board.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest requst, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/WEB-INF/viewer/loginPage.jsp";
	}
	
}
