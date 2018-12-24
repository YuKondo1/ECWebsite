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
<title>注文詳細情報</title>
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
</head>
<body>
<jsp:include page="/baselayout/headerNoImage.jsp"/>
	<main>
	<div class="row div1">
		<div class="col-12 text-muted bg-light text-center"
			style="margin-top: 80px;">注文詳細情報</div>
		<div class="col-1 text-muted text-center"
			style="height: 350px; padding: 20px;"></div>
		<div class="col-10 text-muted text-center"
			style="height: 350px; padding: 20px;">
			<table class="table">
			<thead class="thead-light">
				<tr>
					<th>購入者ID</th>
					<th>購入者名</th>
					<th>電話番号</th>
					<th>郵便番号</th>
					<th>住所</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${uib.id}</td>
					<td>${uib.name}</td>
					<td>${uib.phone}</td>
					<td>${uib.postalCode}</td>
					<td>${uib.address}</td>
				</tr>
			</tbody>
			</table>
			<table class="table">
			<thead class="thead-light">
				<tr>
					<th>商品名</th>
					<th>金額</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${itemList}" varStatus="status">
					<tr>
						<td>
							<a href="ItemDetail?id=${item.id}" style="text-decoration: none;">
								${item.name}
							</a>
						</td>
						<td>
							<a href="ItemDetail?id=${item.id}" style="text-decoration: none;">
								<c:set var="foo" value="${item.price}"/>
								<fmt:formatNumber value="${foo}" pattern="0,000" var="result"/>
								${fn:replace(result, ",", ",")}円（税込）
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
		<div class="col-1 text-muted text-center" style="height: 350px; padding: 20px;"></div>
	</div>
	</main>
<jsp:include page="/baselayout/footer.jsp"/>
</body>
</html>
