<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String scala = "1개만 저장이 가능한 데이터를 scala data 라고 합니다.";
//scala date 의 배열
String [] dbms = {"Oracle", "MySQL", "MongoDB"};

//Map
java.util.Map<String, Object>map = new java.util.HashMap<>();
map.put("overloading", "동일한 클래스에 매개변수의 개수나 자료형이 다른형태의" + "메소드가 동일한 이름으로 2개이상 존재하는 것");
map.put("overriding", "상속관계에 있는 클래스에 동일한 원형의 메소드가 존재하는 것으로" + "하위클래스에서 상위 클래스의 메소드에 기능을 추가하는 것");

java.util.Map<String, Object>map1 = new java.util.HashMap<>();
map1.put("name", "Programming Language");
map1.put("subject", "Java");

java.util.Map<String, Object>map2 = new java.util.HashMap<>();
map2.put("name", "Database");
map2.put("subject", "Oracle");

java.util.List <java.util.Map<String, Object>> list = new java.util.ArrayList();
list.add(map);
list.add(map1);
list.add(map2);



//request객체에 데이터 저장
 request.setAttribute("scala", scala);
 request.setAttribute("dbms", dbms);
 request.setAttribute("map", map);
 request.setAttribute("list", list);
//출력할 곳으로 이동
RequestDispatcher dispatcher = request.getRequestDispatcher("attributedisplay.jsp");
dispatcher.forward(request, response);

 


%>