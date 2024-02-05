<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@page import="java.util.ArrayList" %> 
<%@page import="tw.com.beans.Item" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<%
	@SuppressWarnings("unchecked") // 抑制類型安全警告
	ArrayList<Item> list = (ArrayList<Item>)session.getAttribute("itemList");
	%>
	<ul>
	<%for(Item it : list){ %>
		<li><%=it.getId()%>:<%=it.getName() %></li>
	<%} %>
	</ul>
</body>
</html>