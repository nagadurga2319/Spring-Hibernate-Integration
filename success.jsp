<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteStudent(studentId)
	{
		if(confirm('Do you want to delete this student?'))
			{
				var url='delete/'+studentId;
				window.location.href=url;
			}
	}
</script>
</head>
<body>
	<center>
		<h3>Student Success</h3>
		<table border="1">
			<tr>
				<th>Student Id</th>
				<th>Student name</th>
				<th>Age</th>
				<th>course</th>
				<th>Date of Birth</th>
				<th>Gender</th>
				<th>Action</th>

			</tr>
			<c:forEach items="${studentList}" var="student">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.age}</td>
					<td>${student.course}</td>
					<td>${student.dob}</td>
					<td>${student.gender}</td>
					<%-- <td><a href="<c:url value="/fetchById/${employee.id}"/>">Edit</a>
        	<a href="<c:url value="/delete/${employee.id}"/>">Delete</a>
        </td> --%>

					<td><a href="<c:url value="/fetchById/${student.id}"/>"> <img
							src="<c:url value='/images/vcard_edit.png'/>"
							title="Edit student" />
					</a> <img src="<c:url value='/images/vcard_delete.png'/>"
						title="Delete student"
						onclick="javascript:deleteStudent(${student.id})" /></td>

				</tr>
			</c:forEach>
		</table>

	</center>
</body>
</html>