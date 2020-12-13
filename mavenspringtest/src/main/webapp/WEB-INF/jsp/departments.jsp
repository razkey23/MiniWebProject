<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
	<meta charset="ISO-8859-1">
	<title>index</title>
</head>
<body>
<h1>List of Departments</h1>

<form method="Get" action="back">
    <a>
 		<button name="Back">Back</button>
   </a>
</form>


<table>
	<tr>
		<th align="center">Department Id</th>
		<th align= "center">Department's Name</th>
		<th align= "center">Department's LocId</th>
	</tr>
    <c:forEach items="${listdepts}" var="dept">
        <tr>
            <td align="center"><c:out value="${dept.getDeptid()}"/></td>
            <td align="center"><c:out value="${dept.getDname()}"/></td>
            <td align="center"><c:out value="${dept.getLocId()}"/>
             <td>
             	<FORM NAME="Go To" METHOD="Get" Action="${dept.getLocId()}/department/${dept.getDeptid()}">
        			<INPUT TYPE="SUBMIT" NAME="locbutton" VALUE="See Employees"/>
    			</FORM> 
    	     </td>
        </tr>
    </c:forEach>
</table>

</body>

</html>