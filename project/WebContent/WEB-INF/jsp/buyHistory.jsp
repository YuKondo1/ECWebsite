<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>購入履歴</title>
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
	<div class="row div1">
		<div class="col-12 text-muted bg-light text-center"
			style="margin-top: 80px;">購入履歴</div>
		<div class="col-2 text-muted text-center"
			style="height: 350px; padding: 20px;"></div>
		<div class="col-8 text-muted text-center"
			style="height: 350px; padding: 20px;">
			<table>
				<tr>
					<th>購入日時</th>
					<th>購入内容</th>
				</tr>
				<tr>
					<td>2018年1月1日</td>
					<td>
						<ul>
							<li>あなごめし</li>
							<li>あなごの笹蒸し</li>
						</ul>
					</td>
				</tr>
			</table>
		</div>
		<div class="col-2 text-muted text-center"
			style="height: 350px; padding: 20px;"></div>
	</div>
	</main>
<jsp:include page="/baselayout/footer.jsp"/>
</body>
</html>
