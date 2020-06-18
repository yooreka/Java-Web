<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jstl core 기능 사용을 위한 라이브러리 설정 -->
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 변수 생성 -->
<c:set var="score" value="87"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core</title>
</head>
<body>
	<!-- score 라는 속성 출력 -->
	점수:${score}<br/>
	
	<c:set var="id" value="ggangpae1" />
	<!-- id 가 있으면 로그아웃 없으면 로그인을 출력 -->
	<c:if test="${id == null}">
		로그인
	</c:if>
	<c:if test="${id != null}">
		${id} 로그아웃
	</c:if>
	
	<!-- 위와 동일한 처리를 c:choose로 처리 -->
	<c:choose>
		<c:when test="${id == null}">
			로그인
		</c:when>
		<c:otherwise>
			로그아웃
		</c:otherwise>
	</c:choose>
	<br/>
	수량:<select name="count">
	   <c:forEach begin="1" end="10" var="num">
	   <option value="${num}">${num}</option>
	   </c:forEach>
	
	</select>
	<%
	  String [] ar = {"nike", "adidas", "puma"};
	request.setAttribute("brand",ar);
	%>
	<br/><select name="variablepassing">
	<c:forEach var="item" items="${brand}">
	    <option value= "${item}">${item}</option>
	
	</c:forEach>
	</select>
	<% 
	java.util.Map<String, Object>map = new java.util.HashMap<>();
	map.put("name", "overloading동일한 클래스에 매개변수의 개수나 자료형이 다른형태의" + "메소드가 동일한 이름으로 2개이상 존재하는 것");
	map.put("subject", "overring상속관계에 있는 클래스에 동일한 원형의 메소드가 존재하는 것으로" + "하위클래스에서 상위 클래스의 메소드에 기능을 추가하는 것");

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

	
	%>
	
	<table border="1">
	     <tr>
	        <th>이름</th>
	        <th>설명</th>
	        </tr>
	        <c:forEach var="item" items="${list}">
	        <tr>
	           <td>${item.name}</td>
	           <td>${item.subject}</td>
	        </tr>
	        
	        </c:forEach>
	</table>
</body>
</html>

