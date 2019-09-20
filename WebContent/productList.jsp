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
		float:right;
		color:skyblue;
	}
</style>
</head>
<body>

<script>
	var xmlhttp;
	function loadXML(url,func){
		xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatuschange=func;
		xmlhttp.open("get",url,true);
		xmlhttp.send(null);
	}
	
	function submit(){
			
	}


</script>

<c:if test="${!(empty parentuser)}">
	<div class="userstatus">
		<p>当前用户:${parentuser.name}</p>
	</div>
</c:if>

<c:if test="${empty parentuser}">
	<div class="userstatus">
		<p>未登录</p>
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
					<form action="addintocart">
						数量
						<select name="selectnumber">
							<option>0</option>
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
						<input type="hidden" name="pid" value="${product.id}">
						<button type="submit">加入购物车</button>
					</form>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="4"><a href="listcart.jsp" target="_self"><input type="button" value="显示购物车"></a></td>
		</tr>	
	</table>

</div>


</body>
</html>