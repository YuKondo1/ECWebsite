<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>購入手続き確認</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="Materialize/css/style.css">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css">
</head>
<body>
<jsp:include page="/baselayout/headerNoFixedTop.jsp"/>
	<main>
	<div class="row div1">
		<div class="col-12 text-muted bg-light text-center" style="margin-bottom: 40px;">購入手続き確認</div>
		<div class="col-md-2"></div>
		<div class="col-12 col-md-8">
			<table class="table text-center text-muted">
				<thead class="thead-light">
					<tr>
						<th>商品</th>
						<th>値段</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="item" items="${cart}" varStatus="status">
					<tr>
						<td>${item.name}</td>
						<td>
						<c:set var="foo" value="${item.price}"/>
						<fmt:formatNumber value="${foo}" pattern="0,000" var="result"/>
						${fn:replace(result, ",", ",")}円（税込）
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-2"></div>
		<c:if test="${totalPrice != null}">
		<div class="col-12 text-center text-muted">
			<p style="margin-top: 20px;">合計：<c:set var="foo" value="${totalPrice}"/>
			<fmt:formatNumber value="${foo}" pattern="0,000" var="result"/>
			${fn:replace(result, ",", ",")}円</p>
			<hr style="max-width: 200px;">
		</div>
		</c:if>
		<c:if test="${totalPrice == null}">
		<div class="col-12 text-center text-muted">
			<p style="margin-top: 20px;">合計：0円</p>
			<hr style="max-width: 200px;">
		</div>
		</c:if>
		<div class="col-12 text-center" style="margin-top: 40px;">
			<a href="Cart" class="btn btn-outline-secondary">キャンセル</a>
			<a href="BuyResult?totalPrice=${totalPrice}" class="btn btn-outline-success" style="margin-left: 20px;">購入確認</a>
		</div>
	</div>
	</main>
<jsp:include page="/baselayout/footer.jsp"/>
</body>
</html>
