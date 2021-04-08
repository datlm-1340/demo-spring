<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 

<h1>Edit</h1>

<form action="updateUser" method="POST">
	<div>
		<label for="user-email">Email</label>
		<input name="email" id="user-email" value="${ user.email }"/>
	</div>
	<div>
		<label for="user-full-name">Full Name</label>
		<input name="fullName" id="user-full-name" value="${ user.fullName }"/>
	</div>
		
	<input name="id" type="hidden" value="${ user.id }" />
	<button type="submit">Update</button>
</form>
