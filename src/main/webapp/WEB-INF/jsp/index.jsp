<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 

<center style="color: green">
	${msg}
</center>

<form action="createUser" method="POST">
	<div>
		<label for="user-email">Email</label>
		<input name="email" id="user-email"/>
	</div>
	<div>
		<label for="user-full-name">Full Name</label>
		<input name="fullName" id="user-full-name"/>
	</div>
	
	<button type="submit">Submit</button>
</form>

<c:forEach items="${requestScope.users}" var="user">
	<div>
		<div>${ user.email }</div>
		<div>${ user.fullName }</div>
		<a href="/deleteUser?id=${ user.id }">Remove user</a><br />
		<a href="/user?id=${ user.id }">Edit user</a>
	</div>
</c:forEach>
