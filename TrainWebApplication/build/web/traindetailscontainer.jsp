<%-- 
    Document   : traindetailscontainer
    Created on : Jun 19, 2021, 8:50:36 PM
    Author     : Kavindya Nirmani
--%>

<%@page import="java.util.List"%>
<%@page import="lk.entity.Traindetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
List<Traindetails> traindata=(List<Traindetails>)request.getAttribute("traindata");
for (Traindetails tdata : traindata) {
        
    
%>
<table>
    <tbody>
        <tr class="row100 body">
            <td class="cell100 column1"><%=tdata.getIdtraindetails()%></td>
            <td class="cell100 column2"><%=tdata.getTraincode()%></td>
            <td class="cell100 column3"><%=tdata.getLocation()%></td>
            <td class="cell100 column4"><%=tdata.getSpeed()%></td>
            <td class="cell100 column5"><%=tdata.getTemperature()%></td>
            <td class="cell100 column6"><%=tdata.getHumidity()%></td>
            <td class="cell100 column7"><%=tdata.getTraindate()%></td>
            <td class="cell100 column8"><%=tdata.getTraintime()%></td>
        </tr>
    </tbody>
</table>
<%
}
%>