<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<P>${serviceMsg}.</P>
	<body> 
    <table> 
       <tr> 
        <td>姓名 
        </td> 
        <td>密码
        </td> 
       </tr> 
       <!--  loop begin --> 
       <c:forEach var="user" items="${users}" > 
          <tr> 
          <td> <c:out value="${user.uname}" default="wang"/> 
          </td> 
               
          <td> 
           <c:out value="${user.upwd}" default="wang"/> 
          </td> 
          </tr> 
       </c:forEach> 
       <!-- loop end  --> 
    </table>
</body>
</html>