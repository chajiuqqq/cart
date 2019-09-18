<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,DAO.UserDAO"%>
<%
	UserDAO dao=new UserDAO();
	String username=request.getParameter("username");
	//String password=request.getParameter("password");
	//String name=request.getParameter("name");
	

	if(dao.checkUserExisted(username)){
		response.getWriter().println("<span style=\"color:red\">用户已存在</span>");
		request.setAttribute("unameavail", false);
	}else{
		response.getWriter().println("<span style=\"color:green\">可以使用</span>");
		request.setAttribute("unameavail", true);
	}

%>
