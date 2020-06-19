package kr.co.pk.todo.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pk.todo.repository.ToDoDao;

public class ToDoServiceImpl implements ToDoService {
	//Dao를 사용
	private ToDoDao toDoDao;
	
	private ToDoServiceImpl() {
		//DAO 인스턴스를 생성
		toDoDao = ToDoDao.sharedInstance();
	}
	//인터페이스를 implements 한 경우에는 변수는 인터페이스 자료형으로 선언
	private static ToDoService toDoService;
	public static ToDoService sharedInstance() {
		if(toDoService == null) {
			toDoService = new ToDoServiceImpl();
		}
		return toDoService;
	}
	
	@Override
	public void create() {
		System.out.println("서비스에서 데이터 저장");
		toDoDao.create();
	}

	@Override
	public void read() {
		System.out.println("서비스에서 데이터 읽기");
		toDoDao.read();
	}

	@Override
	public void update() {
		System.out.println("서비스에서 데이터 수정");
		toDoDao.update();
	}

	@Override
	public void delete() {
		System.out.println("서비스에서 데이터 삭제");
		toDoDao.delete();
	}
	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) {
		//1.파라미터 읽어오기
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//2.필요한 작업이 있으면 수행
		
		//3.Dao 메소드를 호출해야 하는 경우 Dao 메소드의 
		//파라미터를 만들고 Dao 메소드를 호출 - 결과를 받기
		
		//4.결과를 사용 - 로그인 같은 경우는 성공했을 때 세션에
		//유저 정보를 저장
		request.getSession().setAttribute("id", id);
		request.getSession().setAttribute("nickname",
				"관리자");
	}

}
