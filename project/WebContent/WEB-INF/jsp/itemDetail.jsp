<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商品詳細</title>
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
<jsp:include page="/baselayout/headerNoImage.jsp"/>
	<main>
	<div class="row div1" style="margin-top: 100px;">
		<div class="col-2 col-md-2 text-muted text-center"
			style="height: 600px; padding: 20px;"></div>
		<div class="col-8 col-md-8 text-muted text-center"
			style="height: 600px; padding: 20px;">
			<img src="${item.image}" class="img-fluid"
				style="margin: 20px 0px; max-height: 200px;">
			<p>${item.name}</p>
			<p>${item.price}円（税込）</p>
			<p style="text-align: left;">${item.itemDetail}</p>
		</div>
		<div class="col-2 col-md-2 text-muted text-center"
			style="height: 600px; padding: 20px;"></div>
		<div class="col-12 text-center">
			<a href="UserFavorite?id=${item.id}" class="btn btn-outline-secondary btn-sm my-2 my-md-0"><i class="fas fa-heart fa-lg"></i>お気に入り登録</a>
			<a href="Cart?id=${item.id}" class="btn btn-outline-success btn-sm my-2 my-md-0" style="margin-left: 20px;"><i class="fas fa-cart-plus fa-lg"></i>カートに入れる</a>
		</div>
	</div>
	</main>
<jsp:include page="/baselayout/footer.jsp"/>
</body>
</html>
