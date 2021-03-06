<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Registration Page</title>
</head>
<body>
	<center>
		<h3>Student Registration Form</h3>
		<c:url var="action" value="/saveStd"></c:url>
		<form:form action="${action}" method="post" commandName="stdForm"
			novalidate="novalidate">
			<table>

				<tr>
					<td>Student Name:</td>
					<td><form:input path="name" /><font color="red"><form:errors
								path="name" /></font></td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><form:input path="age" /><font color="red"><form:errors
								path="age" /></font></td>
				</tr>
				<tr>
					<td>Course:</td>
					<td><form:input path="course" /><font color="red"><form:errors
								path="course" /></font></td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td><form:input type="date" path="dob" /><font color="red"><form:errors
								path="dob" /></font></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><form:radiobutton path="gender" value="MALE" />MALE <font
						color="red"><form:errors path="gender" /></font> <form:radiobutton
							path="gender" value="FEMALE" />FEMALE <font color="red"><form:errors
								path="gender" /></font></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add Student" /></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>