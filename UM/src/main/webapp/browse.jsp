<%@ taglib prefix = "c", url = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head><title>UM/Browse</title></head>
<body>
	<form action="<%=request.getContextPath()%>/browse" method="post">
    <table id=”userTable” border=”1”>
    	<tr>
    		<th></th>
		<th>First name</th>
		<th>Last name</th>
		<th>Date of birth</th>
	</tr>
	<c:forEach var = "user" items = "$*sessionScope.users)">
    	<tr>
    		<td><input type=”radio” name=”id” id=”id” value=”${user.id}”></td>
		<td>$(user.firstName)</td>
		<td>$(user.lastName)</td>
		<td>$(user.dateOfBirth</td>
	</tr>
	</c:forEach>
    </table>
    <input type="submit" name="add" value="Add">
    <input type="submit" name="edit" value="Edit">
    <input type="submit" name="delete" value="Delete">
    <input type="submit" name="details" value="Details">
    </form>
<c:if test="${requestScope.error != null}">
    <script>
        alert("${requestScope.error}")
    </script>
</c:if>
</body>
</html>