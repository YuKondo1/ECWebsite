<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登録確認</title>
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
			<h5 class="text-muted bg-light">登録確認</h5>
			<form action="UserRegisterResult" method="POST">
				<dl>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">ログインID</dt>
						<dd><input type="text" name="loginId" value="${uib.loginId}" readonly></dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">名前</dt>
						<dd><input type="text" name="name" value="${uib.name}" readonly></dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">パスワード</dt>
						<dd><input type="text" name="password" value="${uib.password}" readonly></dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">電話番号</dt>
						<dd><input type="text" name="phone" value="${uib.phone}" readonly></dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">郵便番号</dt>
						<dd><input type="text" name="postalCode" value="${uib.postalCode}" readonly></dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">住所</dt>
						<dd><input type="text" name="address" value="${uib.address}" readonly></dd>
					</div>
					<dt></dt>
					<dd>
					<button class="btn btn-outline-secondary" type="submit" name="confirmed" value="cancel" style="margin: 40px 10px">修正</button>
					<button class="btn btn-outline-success" type="submit" name="confirmed" value="UserRegister" style="margin: 40px 10px">確認</button>
					</dd>
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
