<%-- 
    Document   : ViewIrisDataset
    Created on : Jun 11, 2019, 11:27:37 AM
    Author     : Acer
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashSet"%>
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
            <h2>IRIS CLUSTERS HERE</h2>
             <tr>  
   <%
   Connection con=Dbconnection.getConnection();
   Statement st=con.createStatement();
    Statement st1=con.createStatement();
  ResultSet rs = st.executeQuery("SELECT distinct class FROM iris");
  ArrayList s=new ArrayList();
   while(rs.next()){
     String class1=rs.getString("class");  
   s.add(class1);
   }
   for(int i=0;i<s.size();i++){
        String name=(String)s.get(i);
       %>
      <table>
          <h2>Class:<%=name%></h2>
                     <tr>
                     <th>SEPAL LENGTH IN CM</th>
                     <th>SEPAL WIDTH IN CM</th>
                     <th>PETAL LENGTH IN CM</th>
                     <th>PETAL WIDTH IN CM</th></tr>
       <%
       
  
  ResultSet rs1 = st.executeQuery("SELECT * FROM iris where class='"+name+"'");          
while(rs1.next()){
    
%>
             
<tr>
<td><%=rs1.getString(1)%></td>
<td><%=rs1.getString(2)%></td>
<td><%=rs1.getString(3)%></td>
<td><%=rs1.getString(4)%></td>

</tr>
          <%

} }
   %>
        </table>
         
    </body>
</html>
