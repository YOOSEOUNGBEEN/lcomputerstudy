<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세</title>
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
		color:#000;
		font-weight:700px;
		border:none;
		cursor:pointer;
		padding:10px;
		display:inline-block;
	}
</style>
<body>
	<h1>게시판 상세페이지</h1>
	<table>
	  <tr>
			<td>글 번호</td>
			<td>${board.b_idx}</td>		
		</tr>
		<tr>
			<td>제목</td>
			<td>${board.b_title}</td>		
		</tr>
		<tr>
			<td>내용</td>
			<td>${board.b_contents}</td>		
		</tr>
		<tr>
			<td>조회수</td>
			<td>${board.b_count}</td>		
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.b_writer}</td>		
		</tr>
		<tr>
			<td>작성일시</td>
			<td>${board.b_date}</td>		
		</tr>
		<tr style="height:50px;"> <%--표와  버튼과의 거리--%>
		<td style="border:none;">
			<a href="board-edit.do?b_idx=${board.b_idx}" style="width:70%;font-weight:700;background-color:blue;color:#fff;" >수정</a>
		</td>
		<td style="border:none;">
			<a href="board-delete.do?b_idx=${board.b_idx}" style="width:70%;font-weight:700;background-color:red;color:#fff;">삭제</a>
		</td>
		<td style="border:none;">
			<a href="board-insert.do?b_idx=${board.b_idx}" style="width:70%;font-weight:700;background-color:green;color:#fff;">답글등록</a>
		</td>
		</tr>	
	</table>
</body>
</html>