<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<style>
	table {
		border-collapse:collapse;
	}
	table tr th {
		font-weight:700;
	}
	table tr td, table tr th {
		border:1px solid #818181;
		width:200px;
		text-align:center;
	}
	a {
		text-decoration:none;
		color:blue;
		font-weight:700;
	  }
		
</style>
<body>
<h1>게시물 목록</h1>
	<table >
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<c:forEach items="${list}" var="board">
			 <tr>
				<td width="50"><a href="board-detail.do?b_idx=${board.b_idx}">${board.b_idx}</a></td>
				<td width="150">${board.b_title}</td>
				<td>${board.b_writer}</td>
		     <tr>
		</c:forEach>
		<tr style="height:50px;">
		<td style="border:none;">
		
		
		
			<a href="board-insert.do?b_idx=${board.b_idx}" style="width:70%;font-weight:700;background-color:green;color:#fff;">게시글 등록</a>
		</td>
		</tr>
	</table>
</body>
</html>