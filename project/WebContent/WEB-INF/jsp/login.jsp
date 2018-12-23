<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ログイン</title>
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
	<div class="row div1">
		<div class="col-12" style="height: 300px;">
			<h5 class="text-muted bg-light text-center" style="margin-bottom: 30px">ログイン</h5>
			<form action="LoginResult" method="POST" class="text-center">
				<dl>
					<div class="form-group mb-2">
						<dt class="text-muted">会員ID</dt>
						<dd>
							<input type="text" name="loginId">
						</dd>
					</div>
					<div class="form-group mb-2">
						<dt class="text-muted" style="margin-top: 30px">パスワード</dt>
						<dd>
							<input type="text" name="password">
						</dd>
					</div>
					<dt>
						<input type="submit" class="btn btn-sm btn-outline-secondary" name="action" style="margin-top: 20px;" value="ログイン">
					</dt>
				</dl>
			</form>
		</div>
	</div>
	</main>
<jsp:include page="/baselayout/footer.jsp"/>
</body>
</html>
