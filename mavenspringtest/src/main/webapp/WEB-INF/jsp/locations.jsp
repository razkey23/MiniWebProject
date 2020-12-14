<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>

<style>

input[type=submit] {
  width:50%;
  background-color: #4CAF50;
  align:center;
  color: white;
  padding: 14px 20px;
  border: none;
  cursor: pointer;
}
#tapi {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  margin-top:25px;
  table-layout: fixed;
}

#tapi td, #tapi th {
  text-align:center;
  border: 1px solid #ddd;
  padding: 5px;
}

#tapi tr:nth-child(even){background-color: #f2f2f2;}

#tapi tr:hover {background-color: #ddd;}

#tapi th {
  padding-top: 8px;
  padding-bottom: 8px;
  text-align: center;
  background-color: #4CAF50;
  color: white;
}

</style>
<meta charset="ISO-8859-1">
<title>Business Locations</title>
</head>
<body>
<h1 align="center" >Business Locations</h1>
<table id="tapi">
	<tr>
		<th>Location Id</th>
		<th>Location Name</th>
		<th>See Departments Located Here</th>
	</tr>
    <c:forEach items="${listLocations}" var="location">
        <tr>
            <td><c:out value="${location.getLocId()}"/></td>
            <td><c:out value="${location.getLocname()}"/></td> 
            <td>
            <FORM NAME="Go To" METHOD="Get" Action="/location/${location.getLocId()}">
        		<INPUT TYPE="SUBMIT" NAME="locbutton" VALUE="See Departments in ${location.getLocname()}"/>
    		</FORM> 
    		</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>