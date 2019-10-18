<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	var xmlhttp;
	
	function check(){
		xmlhttp=new XMLHttpRequest();
		var uname=document.getElementById("username").value;
		var pw=document.getElementById("password").value;

		var url="logincheck.jsp?username="+uname+"&password="+pw;
		xmlhttp.onreadystatechange=show;
		xmlhttp.open("GET",url,true);
		xmlhttp.send(null);
	}
	function show(){
		if(xmlhttp.readyState==4&&xmlhttp.status==200){
			var res=JSON.parse(xmlhttp.responseText);
			if(res!=null&&res.status=="true"){
				alert("登入成功！");
				location.assign("listProduct");
			}else{
				alert("登入失败！");
			}
		}
		console.log("xmlhttp.responseText:"+xmlhttp.responseText);
	}

</script>
<div align="center">
	
	用户名:<input type="text" id="username"><br/>
	密码:<input type="password" id="password"><br/>
	<button onclick="check()">登入</button>
	<a href="register.jsp" target="_self"><button>注册</button></a>
	

</div>

</body>
</html>