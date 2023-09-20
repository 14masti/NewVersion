<%@ page language="java" import="java.util.*,java.sql.*,java.io.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tagapp" uri="/WEB-INF/Custom.tld" %>
<!DOCTYPE html>
<html>
<head>
    <title>Custom Tag Example</title>
</head>
<body>

    <tagapp:mypost var="db" driver="org.postgresql.Driver" url="jdbc:postgresql://192.168.110.48:5432/plf_training" username="plf_training_admin" password="pff123"/>

    <tagapp:mytag dataSource="${db}" table="masti_emp" displayColumn="ename" valueColumn="empno"/>
    
    <table border="1">
        <tr>
            <th>Employee Name</th>
            <th>Employee Number</th>
        </tr>
        <c:forEach items="${result}" var="row">
            <tr>
                <td>${row.displayValue}</td>
                <td>${row.columnValue}</td>
            </tr>
        </c:forEach>
    </table>
    
</body>
</html>


