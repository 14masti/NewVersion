<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1" import="com.example.*,java.util.*"%>


<!DOCTYPE html>

<html>

<head>

    <title>confirmation Page</title>

</head>

<body style="text-align:center;">

    <h2>Ticket Details</h2>

    <% Ticket t=(Ticket)request.getAttribute("ticket"); %>

    <p><b>PNR: <%= request.getAttribute("pnr") %></b></p>

    <p>Cost: $<%= request.getAttribute("cost") %></p>

    <p>From: <%= t.getFrom() %></p>

    <p>To: <%= t.getTo() %></p>

    <p>Train Name: <%= t.getTrainName() %></p>

    <p>Class: <%= t.getClas() %></p>

    <p>Date: <%= t.getD() %></p>

    <h3>Passengers:</h3>

    <table border="1" style="margin-left:25%;width:50%;height:30%;">

            <th>Name</th>

            <th>Gender</th>

            <th>Age</th>
            
            <th>berth</th>

        </tr>

        <% for (Passenger passenger : t.getPl()) { %>

            <tr>

                <td><%= passenger.getName() %></td>

                <td><%= passenger.getGender() %></td>

                <td><%= passenger.getAge() %></td>
                
                <td><%= passenger.getBerth() %></td>

            </tr>

        <% } %>

    </table>

</body>

</html>


