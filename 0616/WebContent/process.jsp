<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    //파라미터 읽기
     String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");
    //비지니스 로직 수행
    //num1 과 nu2를 정수로 변환해서 더하기
    int result = Integer.parseInt(num1)+Integer.parseInt(num2);
    
    //결과 저장
    session.setAttribute("result", result);
    
    //결과 페이지로 이동
    response.sendRedirect("output.jsp");
    %> 