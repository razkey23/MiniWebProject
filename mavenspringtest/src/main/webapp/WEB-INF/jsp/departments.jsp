<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<style>

input[type=submit] {
  align:center;
  width:70%;
  background-color: #4CAF50;
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


<%@ page isELIgnored="false" %>
	<meta charset="ISO-8859-1">
	<title>Departments</title>
</head>
<body>
<%
    String locationName=(String) request.getAttribute("locationName");
%>
<h1 style="text-align:center">Departments in <%=locationName %></h1>

<form method="Get" action="back">
    <a>
 		<button name="Back">Back</button>
   </a>
</form>


<table id="tapi">
	<tr>
		<th align="center">Department Id</th>
		<th align= "center">Department's Name</th>
		<th align= "center">Department's LocId</th>
		<th>See Employees Working Here</th>
	</tr>
    <c:forEach items="${listdepts}" var="dept">
        <tr>
            <td align="center"><c:out value="${dept.getDeptid()}"/></td>
            <td align="center"><c:out value="${dept.getDname()}"/></td>
            <td align="center"><c:out value="${dept.getLocId()}"/>
             <td>
             	<FORM NAME="Go To" METHOD="Get" Action="${dept.getLocId()}/department/${dept.getDeptid()}">
        			<INPUT TYPE="SUBMIT" NAME="locbutton" VALUE="Employees in ${dept.getDname()}"/>
    			</FORM> 
    	     </td>
        </tr>
    </c:forEach>
</table>

</body>

</html>