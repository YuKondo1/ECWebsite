<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商品登録</title>
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
			<h5 class="text-muted bg-light">商品登録</h5>
			<form action="AdminRegisterResultItem" method="POST">
				<dl>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">商品名</dt>
						<dd>
							<input type="text" name="name">
						</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">商品金額（税込）</dt>
						<dd>
							<input type="text" name="price">
						</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px;">
						<dt class="text-muted">商品説明</dt>
						<dd>
							<textarea name="itemDetail"></textarea>
						</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">商品画像（追加したファイル名を入力）</dt>
						<dd>
							<input type="text" name="image">
						</dd>
					</div>
					<dt>
						<input type="submit" class="btn btn-outline-success" value="商品登録" style="margin: 40px 0px" name="action">
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
