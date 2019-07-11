package com.ja.board.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.board.model.dao.*;




public class DeleteContentProcessHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String c_idx=request.getParameter("c_idx");
		
		ContentDAO contentDAO = new ContentDAO();
		
		contentDAO.deleteByIdx(c_idx);
		
		try {
		response.sendRedirect("./boardPage.do");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
