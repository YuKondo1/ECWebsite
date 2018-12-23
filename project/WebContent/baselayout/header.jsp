<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<header>
		<nav class="navbar navbar-expand-md navbar-light bg-white fixed-top"
			style="max-width: 1080px; margin: 0 auto;">
			<a href="Index" class="navbar-brand"><img src="img/top_logo_ueno.png" style="width: 50px; height: 50px"></a>
			<button class="navbar-toggler" data-toggle="collapse" data-target="#nav1">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="nav1">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<a href="UserFavoriteList" class="nav-link font-weight-bold">お気に入り</a>
					</li>
					<li class="nav-item">
						<a href="BrowsingHistory" class="nav-link font-weight-bold">閲覧履歴</a>
					</li>
					<% boolean isLogin = session.getAttribute("isLogin")!=null?(boolean) session.getAttribute("isLogin"):false; %>
					<%if(isLogin){ %>
					<li class="nav-item">
						<a href="User" class="nav-link font-weight-bold">マイページ</a>
					</li>
					<%}else{ %>
					<li class="nav-item d-md-none">
						<a href="Login" class="nav-link font-weight-bold">ログイン</a>
					</li>
					<li class="nav-item">
						<a href="UserRegister" class="nav-link font-weight-bold">会員登録</a>
					</li>
					<%} %>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<a href="Cart" class="nav-link">
							<i class="fas fa-shopping-cart fa-lg"></i>
						</a>
					</li>
				</ul>
				<hr class="d-md-none border-secondary my-2">
				<form action="SearchResult" method="POST" class="form-inline ml-right">
					<label class="sr-only" for="kw">検索キーワード</label> <input type="text" name="searchKeyWord" class="form-control form-control-sm mr-sm-2 my-2 my-md-0" placeholder="キーワード" id="kw">
					<button type="submit" class="btn btn-white btn-sm my-2 my-md-0" name="action">
						<i class="fas fa-search fa-lg search-gray"></i>
					</button>
				</form>
			</div>
		</nav>
		<div class="jumbotron" style="background: url(img/tenpo_iriguchi.jpg); background-size: cover; margin-top: 50px;">
			<img src="img/uenologo_shirotouka.png" class="img-fluid" alt="うえのロゴ" width="346" height="362">
		</div>
	</header>