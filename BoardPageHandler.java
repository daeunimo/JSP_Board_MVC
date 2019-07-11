package com.ja.board.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.board.model.dto.*;
import com.ja.board.model.dao.*;
import java.util.*;
import com.ja.board.model.vo.*;


public class BoardPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<ContentData> listContentData = 
				new ArrayList<ContentData>();
		
		ContentDAO contentDAO = new ContentDAO();
		ArrayList<ContentDTO> contentList=contentDAO.selectAll(); //nick을 알 수 없음
		
		MemberDAO memberDAO = new MemberDAO();
		
		//모으고 엮기
		for(ContentDTO content : contentList) {
			MemberDTO memberDTO= memberDAO.selectByIdx(content.getM_idx());
		
			ContentData data=new ContentData(content, memberDTO);
		
			listContentData.add(data);
		}
		
		request.setAttribute("listContent",listContentData);
		
		
		return "/WEB-INF/viewer/boardPage.jsp"; //포워딩
	}

}
