<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者用ページ</title>
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
		<div class="col-3 d-none d-md-block" style="height: 300px; margin-top: 120px;">
			<ul class="list text-center">
				<li><a href="AdminRegisterNews" style="text-decoration: none;">お知らせ登録</a></li>
				<hr style="margin-top: 2px;">
				<li><a href="AdminDeleteNews" style="text-decoration: none;">お知らせ削除</a></li>
				<hr style="margin-top: 2px;">
				<li><a href="AdminRegisterItem" style="text-decoration: none;">商品登録</a></li>
				<hr style="margin-top: 2px;">
				<li><a href="AdminDeleteItem" style="text-decoration: none;">商品削除</a></li>
				<hr style="margin-top: 2px;">
				<li><a href="AdminConfirmUserBuy" style="text-decoration: none;">注文確認</a></li>
				<hr style="margin-top: 2px;">
				<li><a href="Logout" style="text-decoration: none;">ログアウト</a></li>
				<hr style="margin-top: 2px;">
			</ul>
		</div>
		<div class="col-12 col-md-9 text-center" style="height: 500px">
			<h5 class="text-muted bg-light">管理者情報</h5>
			<div class="form-group mb-2" style="margin-top: 30px">
				<dt class="text-muted">会員ID</dt>
				<dd>${uib.loginId}</dd>
			</div>
			<div class="form-group mb-2" style="margin-top: 30px">
				<dt class="text-muted">名前</dt>
				<dd>${uib.name}</dd>
			</div>
			<div class="form-group mb-2" style="margin-top: 30px">
				<dt class="text-muted">電話番号</dt>
				<dd>${uib.phone}</dd>
			</div>
			<div class="form-group mb-2" style="margin-top: 30px">
				<dt class="text-muted">郵便番号</dt>
				<dd>${uib.postalCode}</dd>
			</div>
			<div class="form-group mb-2" style="margin-top: 30px">
				<dt class="text-muted">住所</dt>
				<dd>${uib.address}</dd>
			</div>
		</div>
		<div class="col-sm-12 d-md-none" style="height: 300px; margin-top: 80px;">
			<ul class="list-inline text-center">
				<li class="list-inline-item"><a href="AdminRegisterNews" style="text-decoration: none;">お知らせ登録<hr style="margin-top: 2px;"></a></li>
				<li class="list-inline-item"><a href="AdminDeleteNews" style="text-decoration: none;">お知らせ削除<hr style="margin-top: 2px;"></a></li>
				<li class="list-inline-item"><a href="AdminRegisterItem" style="text-decoration: none;">商品登録<hr style="margin-top: 2px;"></a></li>
				<li class="list-inline-item"><a href="AdminDeleteItem" style="text-decoration: none;">商品削除<hr style="margin-top: 2px;"></a></li>
				<li class="list-inline-item"><a href="AdminConfirmUserBuy" style="text-decoration: none;">注文確認<hr style="margin-top: 2px;"></a></li>
				<li class="list-inline-item"><a href="Logout" style="text-decoration: none;">ログアウト<hr style="margin-top: 2px;"></a></li>
			</ul>
		</div>
	</div>
	</main>
<jsp:include page="/baselayout/footer.jsp"/>
</body>
</html>
