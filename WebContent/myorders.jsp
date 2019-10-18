<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My orders</title>
<script src="jquery-1.10.2.min.js"></script>

<style>
.title{
	text-align:center;
}
.order{
	width:100%;
	border-collapse:collapse;
}
.orderTitle{
	color:grey;
	
	background-color:skyblue;
}
.itemType{
	text-align:center;
}
.orderItem{
	text-align:center;
}
div{
	width:60%;
	margin:0 auto;
}
.userstatus{
		float:left;
		color:skyblue;
	}

</style>


</head>

<body>

<h1 class="title">我的订单</h1>
<div class="userstatus">
		<p>已登录 当前用户:${parentuser.name}</p><br/>
		<a href="listProduct">继续购物</a>
</div>
	
<div>
<c:forEach items="${myOrders}" var="myOrder" varStatus="st">

	<table class="order">
		<tr>
			<td class="orderTitle" colspan="3">订单编号:${myOrder.id} 日期:${myOrder.date}</td>
		</tr>
		<tr class="itemType">
			<td>物品名称</td>
			<td>物品数量</td>
			<td>小计</td>
		</tr>
		
		<c:forEach items="${myOrder.orderItems}" var="myOrderItem">
		<tr class="orderItem">
			<td>${myOrderItem.product.name}</td>
			<td>${myOrderItem.number}</td>
			<td>${myOrderItem.totalPrice}</td>
		</tr>
		
		</c:forEach>
	
	</table>
	
	<br/>
	<br/>

</c:forEach>
</div>
</body>
</html>