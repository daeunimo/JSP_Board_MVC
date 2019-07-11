package com.ja.board.controller.command;

import javax.servlet.http.*;


public interface CommandHandler {
	public abstract String process(HttpServletRequest request, HttpServletResponse response);
		
	
	
}
