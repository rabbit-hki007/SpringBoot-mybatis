<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file ="common/header.jsp" %>
<script>
    document.title = "Main Page" ;
</script>

	<h3>인덱스 페이지(메인 페이지) 입니다</h3>
	<ul>
		<li><a href="user/listModel">회원리스트 user/listModel로 호출</a></li>
		<li><a href="user/listModelAndView">회원리스트 user/listModelAndView로 호출</a></li>
	</ul>

<%@include file ="common/footer.jsp" %>