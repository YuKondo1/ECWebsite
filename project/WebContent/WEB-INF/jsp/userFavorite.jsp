<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<nav class="navbar navbar-expand-md navbar-light bg-white fixed-top"
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
						<i class="fas fa-search fa-lg search-gray"></i>
					</button>
				</form>
			</div>
		</nav>
	</header>
	<main>
	<div class="row div1">
		<div class="col-12 text-muted bg-light text-center"
			style="margin-top: 80px;">お気に入り</div>
		<div class="col-6 col-md-4 text-muted text-center"
			style="height: 350px; padding: 20px;">
			<a href="#" style="text-decoration: none;"> <img
				src="img/bento.jpg" class="img-fluid"
				style="margin: 20px 0px; max-height: 200px;">
				<p>あなごめし</p>
				<p>3000円（税込）</p>
			</a>
		</div>
		<div class="col-6 col-md-4 text-muted text-center"
			style="height: 350px; padding: 20px;">
			<a href="#" style="text-decoration: none;"> <img
				src="img/bento.jpg" class="img-fluid"
				style="margin: 20px 0px; max-height: 200px;">
				<p>あなごめし</p>
				<p>3000円（税込）</p>
			</a>
		</div>
		<div class="col-6 col-md-4 text-muted text-center"
			style="height: 350px; padding: 20px;">
			<a href="#" style="text-decoration: none;"> <img
				src="img/bento.jpg" class="img-fluid"
				style="margin: 20px 0px; max-height: 200px;">
				<p>あなごめし</p>
				<p>3000円（税込）</p>
			</a>
		</div>
		<div class="col-6 col-md-4 text-muted text-center"
			style="height: 350px; padding: 20px;">
			<a href="#" style="text-decoration: none;"> <img
				src="img/bento.jpg" class="img-fluid"
				style="margin: 20px 0px; max-height: 200px;">
				<p>あなごめし</p>
				<p>3000円（税込）</p>
			</a>
		</div>
	</div>
	</main>
	<footer class="footer mt-auto py-3 bg-light">
		<div class="container text-center">
			<span class="text-muted">Copyright(c) EC Website ALL RIGHTS
				RESERVED.</span>
		</div>
	</footer>
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
