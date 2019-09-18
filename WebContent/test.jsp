<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>
	var xmlhttp;
	function change(){
		xmlhttp=new XMLHttpRequest();
		var value=document.getElementById("input").value;
		var url="ans.jsp?input="+value;
		xmlhttp.onreadystatechange=f;
		xmlhttp.open("get",url,true);
		xmlhttp.send(null);
	}
	
	function f(){
		if(xmlhttp.readyState==4&&xmlhttp.status==200)
			document.getElementById("here").innerHTML=xmlhttp.responseText;
	}
</script>
<input type="text" value="123" id="input"><br/> 
<button onclick="change()">click</button><br/>
<div id="here">321</div>
</body>
</html>