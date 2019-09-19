<%@page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,DAO.UserDAO"%>
<%
	UserDAO dao=new UserDAO();
	String username=request.getParameter("username");
	String password=request.getParameter("password");

	if(dao.confirmUser(username, password)){
		//session.setAttribute("isLogin", true);
		//out.print("<script>alert('登入成功')</script>");
		out.print("{\"status\":\"true\"}");
		String name=dao.getName(username);
		User user=new User(name,username,password);
		session.setAttribute("parentuser",user);
		
	}else{
		//session.setAttribute("isLogin", false);
		//out.print("<script>alert('登入失败')</script>");
		out.print("{\"status\":\"false\"}");
	}

%>
