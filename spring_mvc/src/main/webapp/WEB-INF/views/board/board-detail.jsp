<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 ${board}
 <h3> 글번호 : ${board.boardNum}</h3>
 <h3>글쓴이 : ${board.writer}</h3>
 <h3> 글본문 : ${board.content}</h3>
 <h3>쓴시각 : ${board.createdAt}</h3>
 <!--a태그를 이용해서 목록페이지로 돌아가는 링크 생성 -->
 <br>
<a href="/board/list">목록으로</a>
<br>
<form action="/board/delete" method="post">
 <input type="hidden" name="boardNum" value="${board.boardNum}">
 <button>삭제하기</button>
</form>
</body>
</html>
