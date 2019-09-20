<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<style>
	table{
		border-collapse:collapse;
	}
	td{
		text-align:center;
		border:black solid 1px;
	}

</style>
<body>

<p style="font-size:36px;text-align:center;">购物车</p>

<div align="center">
<table width="50%">
	<tr>
		<td>商品名称</td>
		<td>单价</td>
		<td>数量</td>
		<td>小计</td>
	</tr>
	<c:forEach items="${orderitemlist}" var="orderitem" varStatus="st">
		<tr>
			<td>${orderitem.product.name}</td>
			<td>${orderitem.product.price}</td>
			<td>${orderitem.number}</td>
			<td>${orderitem.totalPrice}</td>
		</tr>
	
	</c:forEach>
	<tr>
		<td colspan="4" style="color:blue;text-align:right">总计:${totalMoney}</td>
	</tr>
	<tr>
		<td colspan="4"><input type="button" value="提交订单"></td>
	</tr>

</table>
</div>

</body>
</html>