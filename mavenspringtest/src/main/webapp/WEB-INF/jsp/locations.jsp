<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Business Locations</title>
</head>
<body>
<h1 align="center">Business Locations</h1>
<table>
	<tr>
		<th align="center">Location Id</th>
		<th align= "center">Location Name</th>
	</tr>
    <c:forEach items="${listLocations}" var="location">
        <tr>
            <td align="center"><c:out value="${location.getLocId()}"/></td>
            
            <td align="center"><c:out value="${location.getLocname()}"/></td> 
            <td>
            <FORM NAME="Go To" METHOD="Get" Action="/location/${location.getLocId()}">
        		<INPUT TYPE="SUBMIT" NAME="locbutton" VALUE="See Departments"/>
    		</FORM> 
    	<td>
        </tr>
    </c:forEach>
</table>
</body>
</html>