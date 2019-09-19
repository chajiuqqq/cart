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
				<form action="">
					数量
					<select>
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
					<input type="submit" value="加入购物车">
				</form>
			</td>						
		</tr>
		
		
		</c:forEach>
	
	</table>

</div>


</body>
</html>