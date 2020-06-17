<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
<%
     //파라미터 읽기
     request.setCharacterEncoding("utf-8");
     String id = request.getParameter("id");
     String pw = request.getParameter("pw");
     String idsave = request.getParameter("idsave");
     
     //idsave의 값을 확인
     //null이면 체크 안한것임
  //   System.out.println(idsave);
     if(idsave == null){
           //id를 저장한 쿠키가 있으면 삭제
           
           //모든 쿠키를 전부 가져오기
    	 Cookie [] cookies = request.getCookies();
           //쿠키가 존재한다면
           if(cookies != null){
        	   for(Cookie cookie : cookies){
        		   if(cookie.getName().equals("id")){
        			   //쿠키 삭제
        			   //쿠키는 삭제하는 메소드가 없고
        			   //수명을 0으로 만들어서 삭제
        			   cookie.setMaxAge(0);
        			   response.addCookie(cookie);
        			   break;
        		   }
        	   }
           }
     }
     //아이디 저장에 체크 한 경우
     else{
    	 //id를 저장한 쿠키를 새엇ㅇ하고 저장
    	 //쿠키를 생성
    	 Cookie cookie = new Cookie("id", id);
         //쿠키를 저장
         response.addCookie(cookie);
     }
     //로그인이 되었을 때 필요한 정보를 Session에 저장
     session.setAttribute("id", id);
     session.setAttribute("nickname", "관리자");
     
     
     //결과 페이지로 리다이렉트
     //response.sendRedirect("loginresult.jsp");
     //결과페이지를 로그인페이지로 바꿈
     response.sendRedirect("index.jsp");
%>
</body>
</html>