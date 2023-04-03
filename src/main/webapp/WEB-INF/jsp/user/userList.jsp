<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> --%>
<%@include file ="../common/header.jsp" %>

<script>
    document.title = "회원 리스트 페이지" ;
</script>

<h2>회원리스트</h2>
 
<table border="1">
    <tr>
        <td>번호</td>
        <td>아이디</td>
        <td>비밀번호</td>
        <td>가입일</td>
        <td>수정일</td>
    </tr>
    
    <c:forEach var="result" items="${userList}">
    <tr>
    	<%-- <td><fmt:formatNumber>${result.id}</fmt:formatNumber></td> --%>
        <td>${result.id}</td>
        <td><a href="/user/userDetailForm?id=${result.id}">${result.username}</a></td>
        <td>${result.password}</td>
        <td>
        	<fmt:formatDate pattern = "yyyy/MM/dd" value="${result.regdate}"/>
        </td>
        <td>
        	<fmt:formatDate pattern = "yyyy/MM/dd" value="${result.updatedate}"/>
        </td>
    </tr>
    </c:forEach>    
    
</table>
<a href="/user/userAddForm">회원가입</a>

<%@include file ="../common/footer.jsp" %>
