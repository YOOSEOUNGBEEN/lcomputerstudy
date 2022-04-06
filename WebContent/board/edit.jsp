<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
</head>
<body>
	<h1>게시물 수정</h1>
        <form action="board-edit-process.do" name="board" method="post">
          	<input type="hidden" name="b_idx" value="${board.b_idx}">
	   		<p> 제목 : <input type="text" name="edit_title" value="${board.b_title}"></p>
	   		<p> 내용 : <input type="text" name="edit_contents" value="${board.b_contents}"></p>
	   		<p> 조회수 : <input type="text" name="edit_count" value="${board.b_count}"></p>
	   		<p> 작성자 : <input type="text" name="edit_writer" value="${board.b_writer}"></p>
	   		<p> 작성일시 : <input type="text" name="edit_date" value="${board.b_date}"></p>
	   		<p> <input type="submit" value="수정완료"></p>
     	 </form>
</body>
</html>