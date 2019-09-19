<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,DAO.UserDAO"%>
<%
	UserDAO dao=new UserDAO();
	String username=request.getParameter("username");
	//String password=request.getParameter("password");
	//String name=request.getParameter("name");
	

	if(dao.checkUserExisted(username)){
		response.getWriter().println("{\"text\":\"用户已存在\",\"unameavail\":\"false\"}");
		
	}else{
		response.getWriter().println("{\"text\":\"可以使用\",\"unameavail\":\"true\"}");
	}

%>
