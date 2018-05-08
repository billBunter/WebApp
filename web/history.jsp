<%-- 
    Document   : history
    Created on : 08.05.2018, 11:44:19
    Author     : Billy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <h1>History</h1>
        <table>
            <tr><th>Time-URL</th></tr>
                    <c:forEach items="${requestScope.history}" var="url">
                <tr>
                    <td><c:out value="${url}"></c:out></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
