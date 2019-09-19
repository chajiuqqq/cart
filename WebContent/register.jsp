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
	var unameavail="false";
	function loadXML(url,func){
		xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=func;
		xmlhttp.open("GET",url,true);
		xmlhttp.send(null);
	}
	
	
	function checkpw(){
		var fpw=document.getElementById("fpw");
		var spw=document.getElementById("spw");
		
		var out=document.getElementById("pwcheck");
		if(fpw.value!=spw.value){
			out.innerHTML="两次密码不一致！";
			out.style.color="red";
		}
		else{
			out.innerHTML="";
		}
	}
	
	function checkuname(){
		var uname=document.getElementById("username").value;
		var url="registercheck.jsp?username="+uname;
		loadXML(url,function(){
			if(xmlhttp.readyState==4&&xmlhttp.status==200){
				var myjson=JSON.parse(xmlhttp.responseText);
				document.getElementById("unamecheck").innerHTML=myjson.text;
				unameavail=myjson.unameavail;
			}
				
				
			console.log("xmlhttp.responseText:"+xmlhttp.responseText);
		})
		
	}
	
	
	function submitinfo(){
		//如果使用el表达式，一开始就替换掉了，不会实时更新，所以即使在js里可以用el，也只能是常量吧。
		console.log("unameavail:"+unameavail);
		if("true"==unameavail){
			var name=document.getElementById("name").value;
			var uname=document.getElementById("username").value;
			var pw=document.getElementById("fpw").value;
			
			var url="registerstore.jsp?name="+name+"&username="+uname+"&password="+pw;
			loadXML(url,function(){
				
			});
			alert("注册成功！请重新登录！");
			history.back();
		}else{
			alert("注册失败！请重新填写！");
		}
		
	}
	

</script>
<div align="center">
	
		用户名:<input type="text" id="username" onkeyup="checkuname()"><span id="unamecheck"></span><br/>
		昵称：<input type="text" id="name"><br/>
		密码:<input type="password" id="fpw"><br/>
		确认密码:<input type="password" id="spw" onkeyup="checkpw()"><span id="pwcheck"></span><br/>
		<button onclick="submitinfo()">确认注册</button>
	

</div>


</body>
</html>