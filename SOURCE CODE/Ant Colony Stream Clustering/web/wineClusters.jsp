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
            <h2>WINE CLUSTERS HERE</h2>
             <tr>  
   <%
   Connection con=Dbconnection.getConnection();
   Statement st=con.createStatement();
    Statement st1=con.createStatement();
  ResultSet rs = st.executeQuery("SELECT distinct classes FROM wine");
  ArrayList s=new ArrayList();
   while(rs.next()){
     String class1=rs.getString("classes");  
   s.add(class1);
   }
   for(int i=0;i<s.size();i++){
        String name=(String)s.get(i);
        %>
             <table>
                 <h2>Class<%=name%></h2>
                 <tr>
        <%
         ResultSet rs11 = st1.executeQuery("select * from wine");
         ResultSetMetaData rsm=rs11.getMetaData();
         int nocolumncount=rsm.getColumnCount();
         for(int j=2;j<=nocolumncount;j++){
             String cname=rsm.getColumnName(j);
             String cn=cname.toUpperCase();
        
       %>
                        <th><%=cn%></th>
                     
       <%
           }%>
        </tr>
  <%
  ResultSet rs1 = st.executeQuery("SELECT * FROM wine where classes='"+name+"'");          
while(rs1.next()){
    
%>
             
<tr>

<td><%=rs1.getString(2)%></td>
<td><%=rs1.getString(3)%></td>
<td><%=rs1.getString(4)%></td>
<td><%=rs1.getString(5)%></td>
<td><%=rs1.getString(6)%></td>
<td><%=rs1.getString(7)%></td>
<td><%=rs1.getString(8)%></td>
<td><%=rs1.getString(9)%></td>
<td><%=rs1.getString(10)%></td>
<td><%=rs1.getString(11)%></td>
<td><%=rs1.getString(12)%></td>
<td><%=rs1.getString(13)%></td>

</tr>
          <%

} }
   %>
        </table>
         
    </body>
</html>
