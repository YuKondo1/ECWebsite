<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<header>
		<nav class="navbar navbar-expand-md navbar-light bg-white" style="max-width: 1080px; margin: 0 auto;">
			<a href="Index" class="navbar-brand">
				<img src="img/top_logo_ueno.png" style="width: 50px; height: 50px">
			</a>
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
					<li class="nav-item">
						<a href="Login" class="nav-link font-weight-bold">ログイン</a>
					</li>
					<li class="nav-item">
						<a href="UserRegister" class="nav-link font-weight-bold">会員登録</a>
					</li>
					<%} %>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="Buy" class="nav-link"><i class="fas fa-shopping-cart fa-lg"></i></a></li>
				</ul>
				<hr class="d-md-none border-secondary my-2">
				<form class="form-inline ml-right">
					<label class="sr-only" for="kw">検索キーワード</label> <input type="search" class="form-control form-control-sm mr-sm-2 my-2 my-md-0" placeholder="キーワード" id="kw">
					<button type="submit" class="btn btn-white btn-sm my-2 my-md-0" name="searchKeyWord">
						<i class="fas fa-search fa-lg"></i>
					</button>
				</form>
			</div>
		</nav>
	</header>