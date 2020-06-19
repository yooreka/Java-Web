package kr.co.pk.todo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.pk.todo.service.ToDoService;
import kr.co.pk.todo.service.ToDoServiceImpl;


@WebServlet({ "*.do", "/index.html", "/" })
public class ToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ToDoService toDoService;
	
    public ToDoController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		//서비스 객체 생성
		toDoService = ToDoServiceImpl.sharedInstance();
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전체 요청에서 공통된 부분을 제거
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		String routePath = 
			requestURI.substring(contextPath.length());
		//요청 방식을 저장
		String method = request.getMethod();
		//세션을 사용하는 경우가 많으면 세션을 미리 생성
		HttpSession session = request.getSession();
		//포워딩을 하기 위한 인스턴스를 저장할 변수
		RequestDispatcher dispatcher = null;
		
		//라우팅: 요청에 따른 서비스를 호출
		//단순 페이지 이동은 포워딩
		//작업을 처리하고 결과 페이지로 이동은 리다이렉트
		//읽기 작업은 포워딩하기도 합니다.
		//새로고침을 했을 때 데이터를 새로 가져와야 한다면 포워딩 
		switch(routePath) {
		case "/index.html":
		case "/":
			dispatcher = 
				request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			break;
		case "/create.do":
			toDoService.create();
			//결과 페이지로 리다이렉트
			break;
		case "/read.do":
			toDoService.read();
			//결과 페이로 포워딩
			break;
		case "/update.do":
			toDoService.update();
			//결과 페이지로 리다이렉트
			break;
		case "/delete.do":
			toDoService.delete();
			break;
		case "/login.do":
			//GET 요청은 입력 페이지로 이동하고 
			//POST 요청은 작업을 처리
			if("GET".equals(method)) {
				dispatcher = 
					request.getRequestDispatcher("user/login.jsp");
				dispatcher.forward(request, response);
			}else {
				//작업 수행
				toDoService.login(request, response);
				//결과 페이지로 이동 
				//이전에 요청한 주소가 있는지 확인
				String path = (String)session.getAttribute("path");
				if(path == null) {
					response.sendRedirect(contextPath);
				}else {
					//이전 요청 주소 삭제
					session.removeAttribute("path");
					response.sendRedirect(path);
				}
			}
			break;
		case "/write.do":
			dispatcher = 
				request.getRequestDispatcher("board/write.jsp");
			dispatcher.forward(request, response);
			break;
		case "/logout.do":
			//로그아웃은 세션을 초기화
			session.invalidate();
			response.sendRedirect(contextPath);
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
