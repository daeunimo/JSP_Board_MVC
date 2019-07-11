package com.ja.board.controller;

import java.io.IOException;
import com.ja.board.controller.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class ControllerUsingURI
 */
@WebServlet("/ControllerUsingURI")
public class ControllerUsingURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	private HashMap<String,CommandHandler> commandMap=new HashMap<String,CommandHandler>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUsingURI() {
        super();
        // TODO Auto-generated constructor stub
        // 어떤 명령어를 받았을 때 어떤 클래스를 실행시킬 것인가? _매핑 (해쉬맵에 키와 값으로 저장)
        commandMap.put("/loginPage.do",new LoginPageHandler());
        commandMap.put("/joinMemberPage.do",new JoinMemberPageHandler());
        commandMap.put("/joinMemberProcess.do",new JoinMemberProcessHandler());
        commandMap.put("/loginProcess.do",new LoginProcessHandler());
        commandMap.put("/boardPage.do",new BoardPageHandler());
        commandMap.put("/writeContentPage.do",new WriteContentPageHandler());
        commandMap.put("/logoutProcess.do",new LogoutProcessHandler());
        commandMap.put("/writeContentProcess.do",new WriteContentProcessHandler());
        commandMap.put("/readContentPage.do",new ReadContentPageHandler());
        commandMap.put("/deleteContentProcess.do",new DeleteContentProcessHandler());
        commandMap.put("/updateContentProcess.do", new UpdateContentProcessHandler());
        commandMap.put("/updateContentPage.do", new UpdateContentPageHandler());
    }	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String command=request.getRequestURI();  //호출된 명령어
		
		command=command.substring(request.getContextPath().length());
		
		CommandHandler handler = commandMap.get(command);
		
		String viewPage="/WEB=INF/viewer/errorPage.jsp";
		
		if(handler != null) {
			viewPage = handler.process(request, response);
		}
		
		if(viewPage!=null) {
			RequestDispatcher dispatcher=
					request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response); //통캣 내부에서 페이지 이동                                                            
		}
		
		
	}
}
