<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会員情報更新</title>
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
<jsp:include page="/baselayout/headerNoFixedTop.jsp"/>
	<main>
	<div class="row div1 text-center">
		<div class="col-12" style="height: 350px">
			<h5 class="text-muted bg-light">会員情報更新</h5>
			<form action="UserUpdateConfirm" method="POST">
				<dl>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">会員ID</dt>
						<dd>
							<input type="text" name="loginId" value="${uib.loginId}">
						</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">名前</dt>
						<dd>
							<input type="text" name="name" value="${uib.name}">
						</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">パスワード</dt>
						<dd>
							<input type="password" name="password" value="${uib.password}">
						</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">パスワード（確認用）</dt>
						<dd>
							<input type="password" name="passwordConfirm" value="${uib.password}">
						</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">電話番号</dt>
						<dd>
							<input type="tel" name="phone" value="${uib.phone}">
						</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">郵便番号</dt>
						<dd>
							<input type="text" name="postalCode" value="${uib.postalCode}">
						</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">住所</dt>
						<dd>
							<input type="text" name="address" value="${uib.address}">
						</dd>
					</div>
					<dt>
						<input type="submit" class="btn btn-outline-success" value="更新" name="action" style="margin-top: 40px">
					</dt>
				</dl>
			</form>
		</div>
	</div>
	</main>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>
