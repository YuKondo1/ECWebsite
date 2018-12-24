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
<title>お気に入り</title>
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
		<div class="col-12 text-muted bg-light text-center" style="margin-top: 80px;">お気に入り</div>
		<c:forEach var="item" items="${itemList}">
			<div class="col-6 col-md-4 text-muted text-center" style="height: 350px; padding: 20px;">
				<a href="ItemDetail?id=${item.id}" style="text-decoration: none;"> <img src="${item.image}" class="img-fluid" style="margin: 20px 0px; max-height: 200px;">
				<p>${item.name}</p>
				<p>
				<c:set var="foo" value="${item.price}"/>
				<fmt:formatNumber value="${foo}" pattern="0,000" var="result"/>
				${fn:replace(result, ",", ",")}円（税込）
				</p>
				</a>
			</div>
		</c:forEach>
	</div>
	</main>
<jsp:include page="/baselayout/footer.jsp"/>
</body>
</html>
