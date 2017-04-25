<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>Social Analytics Top 20 Search Result</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />" />
		<script type="text/javascript" src="<c:url value="/js/jquery-2.0.3.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/bootstrap.min.js" />"></script>
	</head>
	<body>
		<div class="container">
			<h1>Social Analytics Top 20 Search Result</h1>
			<hr>
			<c:if test="${not empty searchResult}">
				<c:forEach var="psr" items="${searchResult}">
					<dl class="dl-horizontal">
						<dt>Site Name</dt>
						<dd>${psr.siteName}</dd>
						<dt>Title</dt>
						<dd>${psr.title}</dd>
						<dt>User Name</dt>
						<dd>${psr.userName}</dd>
						<dt>Content</dt>
						<dd>${psr.content}</dd>
						<dt>Link</dt>
						<dd><a href="${psr.link}" target="_blank">${psr.link}</a></dd>
					</dl>
				<hr>
				</c:forEach>
			</c:if>
		</div>
	</body>
</html>