<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>お知らせ削除</title>
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css">
</head>
<body>
<jsp:include page="/baselayout/headerNoImage.jsp"/>
<main>
	<form action="AdminDeleteNewsResult" method="POST">
	<div class="row div1">
		<div class="col-12 text-muted bg-light text-center" style="margin-top: 80px; margin-bottom: 40px;">お知らせ削除</div>
		<div class="col-1 col-sm-2 col-md-3 text-muted text-center"></div>
		<div class="col-10 col-sm-8 col-md-6 text-muted text-left">
		<c:forEach var="news" items="${newsList}" varStatus="status">
			<ul class="list-unstyled border p-3">
				<li class="media">
					<div class="media-body">
						<fmt:formatDate value="${news.createDate}" pattern="yyyy年MM月dd日"/><br>
						${news.info}
						<p></p>
						<div class="pretty p-default p-curve p-thick">
								<input type="checkbox" id="${status.index}" name="delete_news_id_list" value="${news.id}" />
								<div class="state">
									<label for=""><i class="mdi mdi-che"></i>削除</label>
								</div>
						</div>
					</div>
				</li>
			</ul>
			</c:forEach>
		</div>
		<div class="col-1 col-sm-2 col-md-3"></div>
		<div class="col-12 text-center" style="margin-top: 40px;">
			<p class="text-center">${cartActionMessage}</p>
			<button class="btn btn-outline-secondary" type="submit" name="action">削除</button>
		</div>
	</div>
	</form>
</main>
<jsp:include page="/baselayout/footer.jsp"/>
</body>
</html>
