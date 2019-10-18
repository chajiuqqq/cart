<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-collapse:collapse;
		width:50%;
	}
	td{
		text-align:center;
		border:black solid 1px;
	}
	.userstatus{
		float:left;
		color:skyblue;
	}
	tr:nth-child(2n-1){
		background-color:skyblue;
	}
</style>
</head>
<script src="jquery-1.10.2.min.js"></script>
<body>



<c:if test="${!(empty parentuser)}">
	<div class="userstatus">
		<p>已登录 当前用户:${parentuser.name}</p><br/>
		<a href="myorders">我的订单</a>
		<a href="checkout.jsp">退出</a>
	</div>
</c:if>

<c:if test="${empty parentuser}">
	<div class="userstatus">
		<a href="login.jsp" target="_self">登陆</a>
	</div>
</c:if>


<p style="font-size:36px;text-align:center;">商品列表</p>

<div id="dtable" align="center">
	<table>
	
		<tr>
			<td>id</td>
			<td>名称</td>
			<td>价格</td>
			<td>购买</td>
		
		</tr>
		
		<c:forEach items="${products}" var="product" varStatus="st">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>
					
						数量
						<select class="sel" name="selectnumber" pid="${ product.id}">
							<option selected="selected">0</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
						</select>
						<button class="btn" pid="${ product.id}">加入购物车</button>
					
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="4"><a href="listcart.jsp" target="_self"><input type="button" value="显示购物车"></a></td>
		</tr>	
	</table>

</div>

<script>
/*
	var xmlhttp;
	function loadXML(url,func){
		xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatuschange=func;
		xmlhttp.open("get",url,true);
		xmlhttp.send(null);
	}
	

	var btns=document.getElementsByClassName("btn");
	
	console.log("btns.length:"+btns.length);
	
	for(var i=0;i<btns.length;i++){
		btns[i].onclick=function(){
				var apid=this.attributes["pid"].nodeValue;
				var sel=document.getElementsByClassName("sel")[pid=apid].value;
				console.log("pid:"+pid);
				var url="addintocart?pid="+pid+"&selectnumber="+sel;
				loadXML(url,function(){
					if(xmlhttp.readyState==4&&xmlhttp.status==200){
						alert("加入成功！");
					}
				});
			};
	}*/
	
	//rewrite with jQuery
	$(function(){
		$(".btn").click(function(){
			var pid=$(this).attr("pid");
			console.log("pid:"+pid);
			var num=$(".sel[pid="+pid+"]").val();
			console.log("num:"+num);
			$.get(
				"addintocart?pid="+pid+"&selectnumber="+num
			);
			alert("已加入购物车!");
		});
	})
	
	

</script>


</body>
</html>