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
<title>あなごめし うえの</title>
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
<jsp:include page="/baselayout/header.jsp"/>
	<main>
	<div class="row div1">
	<% boolean isLogin = session.getAttribute("isLogin")!=null?(boolean) session.getAttribute("isLogin"):false; %>
	<%if(isLogin){ %>
		<div class="col-12" style="height: 300px">
			<h5 class="text-muted bg-light">お知らせ</h5>
				<table class="text-muted">
				<c:forEach var="news" items="${newsList}">
					<tr>
						<th><fmt:formatDate value="${news.createDate}" pattern="yyyy年MM月dd日"/></th>
						<td>&nbsp;&nbsp;</td>
						<td>${news.info}</td>
					</tr>
					</c:forEach>
				</table>
		</div>
	<%}else{ %>
		<div class="col-3 d-none d-md-block"
			style="height: 300px; margin-top: 40px;">
			<form action="LoginResult" method="POST">
				<dl>
					<div class="form-group mb-2">
						<dt class="text-muted">会員ID</dt>
						<dd>
							<input type="text" name="loginId">
						</dd>
					</div>
					<div class="form-group mb-2">
						<dt class="text-muted">パスワード</dt>
						<dd>
							<input type="text" name="password">
						</dd>
					</div>
					<dt>
						<input type="submit" class="btn btn-sm btn-outline-secondary" name="action" style="margin-top: 20px;" value="ログイン">
					</dt>
				</dl>
			</form>
			<a href="UserRegister" class="btn btn-block btn-outline-secondary" style="margin-top: 40px;">会員登録</a>
		</div>
		<div class="col-12 col-md-9" style="height: 300px">
			<h5 class="text-muted bg-light">お知らせ</h5>
				<table class="text-muted">
				<c:forEach var="news" items="${newsList}">
					<tr>
						<th>${news.createDate}</th>
						<td>&nbsp;&nbsp;</td>
						<td>${news.info}</td>
					</tr>
					</c:forEach>
				</table>
		</div>
	<%} %>
	</div>
	<div class="row div1">
		<div class="col-12 text-muted bg-light text-center">商品一覧</div>

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
