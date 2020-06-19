

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class authenticationcontroller
 */
@WebServlet("/authentication/*")
public class authenticationcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authenticationcontroller() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//루트경로 찾아오기
	String contextPath = request.getContextPath();
	//사용자의 요청 경로 찾기
	String requestURI = request.getRequestURI();
	//사용자의 요청 경로를 가지고 라우팅을 하는 것이 기능
	//사용자의 요청 경로에는 루트 경로가 포함되어 있음.
	//System.out.println(contextPath);
	//System.out.println(requestURI);
	//공통된 부분을 제외한 부분만 추출
	//여기까지 작업은 프레임워크가 해줌
	String routePath = requestURI.substring(contextPath.length() + 16);
	//System.out.println(routePath);
	//전송 방식을 찾아옵니다 get or post
    String method = request.getMethod();	
	
    //포워딩에 사용할 변수
    RequestDispatcher dispatcher = null;
    
    //라우팅
    switch(routePath) {
    case "login":
    	if(method.contentEquals("GET")) {
    		//login.jsp파일로 포워딩
    		dispatcher = request.getRequestDispatcher("../ex/login1.jsp");
    		dispatcher.forward(request, response);
    	}else {
    		//로그인처리 - main.jsp로  이동하도록 생성
    		//리다이렉트를 할 때 파일로 직접 리다이렉트 하지말고
    		//요청으로 리다이렉트를 한 후 그요청을 처리하는 곳에서 포워딩
    		//하도록 하는 것을 권장.
    		response.sendRedirect("main");
    	}
    	break;
    case "main":dispatcher = request.getRequestDispatcher("../ex/main.jsp");
	dispatcher.forward(request, response);
    	break;
    
    case "write":dispatcher = request.getRequestDispatcher("../ex/write.jsp");
	dispatcher.forward(request, response);
    	break;
    
    
    }
    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
