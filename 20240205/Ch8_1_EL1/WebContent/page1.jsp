<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@page import="tw.com.beans.MyUser"  %>    
<%@page import="tw.com.beans.MyItem"  %>    
<%@page import="java.util.List,java.util.Map"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<%
	 MyItem myItem = (MyItem)request.getAttribute("Item1");	
	 MyUser myUser = (MyUser)session.getAttribute("User1"); 
	 Map<String,MyUser> userMap = (Map)application.getAttribute("userMap");
	 MyUser myUser1 =  userMap.get("user1");
	 MyUser myUser2 =  userMap.get("user2 vivin");
	%>
	<p><%=myItem.getName() %> : <%=myItem.getPrice() %></p>
	<p><%=myUser.getName() %> : <%=myUser.getAge()%></p>
	
	<h2>UserMap</h2>
	<p><%=myUser1.getName()%>:<%=myUser1.getAge()%></p>
	<p><%=myUser2.getName()%>:<%=myUser2.getAge()%></p>
</body>
</html>