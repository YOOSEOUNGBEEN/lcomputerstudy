<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계층형 계시판</title>
</head>
<body>
<h2> 게시판 </h2>
<form action="board-insert-process.do" name="user" method="post">
		<p> 제목 : <input type="text" name="title"></p>
		<p> 내용: <textarea id="content" name="contents" cols="30" rows="5"></textarea><br>    
		<p> 조회수 : <input type="text" name="b_count">
		<p> 작성자 : <input type="text" name="writer"></p>
		<p> 작성일시 : <input type="text" name="b_date"></p>
		<p> <input type="submit" value="글등록"></p>
</form>
</body>
</html>