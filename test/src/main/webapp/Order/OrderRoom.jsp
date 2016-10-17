<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OrderRoom</title>
</head>
<body>
	<H3>Hello!</H3>

	<form action="<c:url value='/OrderRoom/OrderRoom.Controller'/>" method="post">
		<table>
<!-- 			<tr> -->
<!-- 				<td>*會員編號:</td> -->
<%-- 				<td><input type="text" name="memberID" value="${param.memberID}"></td> --%>
<%-- 				<td><span class="error">${error.memberID}</span></td> --%>
<!-- 			</tr> -->
			
<!-- 			<tr> -->
<!-- 				<td>*會員訂單日期:</td> -->
<%-- 				<td><input type="text" name="memberDate" value="${param.memberDate}"></td> --%>
<%-- 				<td><span class="error">${error.memberDate}</span></td> --%>
<!-- 			</tr> -->
			
<!-- 			<tr> -->
<!-- 				<td>*房間總金額:</td> -->
<%-- 				<td><input type="text" name="roomTotalSum" value="${param.roomTotalSum}"></td> --%>
<%-- 				<td><span class="error">${error.roomTotalSum}</span></td> --%>
<!-- 			</tr> -->
			
<!-- 			<tr> -->
<!-- 				<td>*訂單總金額:</td> -->
<%-- 				<td><input type="text" name="memberSum" value="${param.memberSum}"></td> --%>
<%-- 				<td><span class="error">${error.memberSum}</span></td> --%>
<!-- 			</tr> -->
			
<!-- 			<tr> -->
<!-- 				<td>*是否刪除:</td> -->
<%-- 				<td><input type="text" name="haveDelete" value="${param.haveDelete}"></td> --%>
<%-- 				<td><span class="error">${error.haveDelete}</span></td> --%>
<!-- 			</tr> -->
			
<!-- 			<tr> -->
<!-- 				<td>*訂單編號:</td> -->
<%-- 				<td><input type="text" name="orderID" value="${param.orderID}"></td> --%>
<%-- 				<td><span class="error">${error.orderID}</span></td> --%>
<!-- 			</tr>										 -->
			
			<tr>
				<td>入住日期:</td>
				<td><input type="text" name="inDate" value="${param.inDate}"></td>
				<td><span class="error">${error.inDate}</span></td>
			</tr>
			<tr>
				<td>退房日期:</td>
				<td><input type="text" name="outDate" value="${param.outDate}"></td>
				<td><span class="error">${error.outDate}</span></td>
			</tr>
			
<!-- 			<tr> -->
<!-- 				<td>房間小計:</td> -->
<%-- 				<td><input type="text" name="roomSum" value="${param.roomSum}"></td> --%>
<%-- 				<td><span class="error">${error.roomSum}</span></td> --%>
<!-- 			</tr> -->
			
			<tr>
				<td><input type="hidden" name="roomCode"/></td>
				<td><span class="error">${error.insertResult}</span></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="submit" value="訂房">
					<input type="reset" value="清除"></td>
			</tr>
		</table>

	</form>

</body>
</html>