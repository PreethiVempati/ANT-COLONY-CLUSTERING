<%-- 
    Document   : ViewIrisDataset
    Created on : Jun 11, 2019, 11:27:37 AM
    Author     : Acer
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="dbcon.Dbconnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IRIS DATASET</title>
        <link href="tablestyle.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <table>
            <h2>IRIS DATA HERE</h2>
             <tr>  
   <%
   Connection con=Dbconnection.getConnection();
   Statement st=con.createStatement();
    Statement st1=con.createStatement();
  ResultSet rs = st.executeQuery("SELECT * FROM iris");
    ResultSetMetaData rsMetaData = rs.getMetaData();
     int numberOfColumns = rsMetaData.getColumnCount();
     for(int i=1;i<numberOfColumns+1;i++){
          String columnName = rsMetaData.getColumnName(i);
          String uclname=columnName.toUpperCase();
          %>
          <th><%=uclname%></th>
         <%}
             %>
               </tr>
          <%
                ResultSet rs1 = st1.executeQuery("SELECT * FROM iris");
while(rs1.next()){
%>
<tr>
<td><%=rs1.getString(1)%></td>
<td><%=rs1.getString(2)%></td>
<td><%=rs1.getString(3)%></td>
<td><%=rs1.getString(4)%></td>
<td><%=rs1.getString(5)%></td>
</tr>
          <%

} 
   %>
        </table>
    </body>
</html>