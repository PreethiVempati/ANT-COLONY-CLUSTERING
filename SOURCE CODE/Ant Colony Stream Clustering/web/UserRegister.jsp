<%-- 
    Document   : AdminLogin
    Created on : 22 Apr, 2019, 11:02:07 AM
    Author     : VENKAT
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.sql.*"%>
<%@page import="dbcon.Dbconnection"%>
<%
    String fname=request.getParameter("fname");
    String lname=request.getParameter("lname");
    String email=request.getParameter("email");
    String mobile=request.getParameter("mobile");
    String location=request.getParameter("location");
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    try
    {
      Connection con=Dbconnection.getConnection();
      Statement st= con.createStatement();
      ResultSet rs=st.executeQuery("select count(*) from user where username='"+username+"'");
      while(rs.next())
      {
          int count=rs.getInt(1);
          if(count==0)
          {
              int i=st.executeUpdate("insert into user values('"+fname+"','"+lname+"','"+email+"','"+mobile+"','"+location+"','"+username+"','"+password+"')");
              if(i>0)
              {
               %>
       <script type="text/javascript">
           window.alert("User  Registration SuccessFully");
           window.location="User.jsp";
           
           </script>
        <%   
              }
else
{
%>
       <script type="text/javascript">
           window.alert("User Registration Fail");
           window.location="AdminHome.jsp";
           
           </script>
        <%
}
          }
       %>
       <script type="text/javascript">
           window.alert("User Already Exist");
           window.location="Register.jsp";
           
           </script>
        <%
      }
{
 %>
       <script type="text/javascript">
           window.alert("User Already Exist");
           window.location="Register.jsp";
           
           </script>
        <%
}
    }
    catch(Exception e)
    {
        out.println(e);
    }
    %>


