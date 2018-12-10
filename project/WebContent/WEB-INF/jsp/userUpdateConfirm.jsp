<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>更新情報確認</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-light bg-white"
			style="max-width: 1080px; margin: 0 auto;">
			<a href="index.html" class="navbar-brand"><img
				src="img/top_logo_ueno.png" style="width: 50px; height: 50px"></a>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#nav1">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="nav1">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="userFavorite.html"
						class="nav-link font-weight-bold">お気に入り</a></li>
					<li class="nav-item"><a href="browsingHistory.html"
						class="nav-link font-weight-bold">閲覧履歴</a></li>
					<li class="nav-item"><a href="user.html"
						class="nav-link font-weight-bold">マイページ</a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="buy.html" class="nav-link"><i
							class="fas fa-shopping-cart fa-lg"></i></a></li>
				</ul>
				<hr class="d-md-none border-secondary my-2">
				<form class="form-inline ml-right">
					<label class="sr-only" for="kw">検索キーワード</label> <input
						type="search"
						class="form-control form-control-sm mr-sm-2 my-2 my-md-0"
						placeholder="キーワード" id="kw">
					<button type="submit" class="btn btn-white btn-sm my-2 my-md-0"
						name="searchKeyWord">
						<i class="fas fa-search fa-lg"></i>
					</button>
				</form>
			</div>
		</nav>
	</header>
	<main>
	<div class="row div1 text-center">
		<div class="col-12" style="height: 350px">
			<h5 class="text-muted bg-light">更新情報確認</h5>
			<form>
				<dl>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">会員ID</dt>
						<dd>12345678</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">名前</dt>
						<dd>テスト太郎</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">パスワード</dt>
						<dd>1234321</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">電話番号</dt>
						<dd>0901234123</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">郵便番号</dt>
						<dd>1550034</dd>
					</div>
					<div class="form-group mb-2" style="margin-top: 30px">
						<dt class="text-muted">住所</dt>
						<dd>東京都テスト区1-1-1</dd>
					</div>
					<dt>
						<input type="submit" class="btn btn-outline-secondary" value="確認"
							style="margin-top: 40px">
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
