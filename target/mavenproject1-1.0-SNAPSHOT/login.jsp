<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
String user=request.getParameter("user");
String password=request.getParameter("password");
Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill","root","8111");


Statement st= con.createStatement();
ResultSet rs=st.executeQuery("SELECT * FROM user where name='"+user+"' and password='"+password+"'");
try{
rs.next();
if(rs.getString("password").equals(password)&&rs.getString("user").equals(user))
{
out.println("Welcome " +user);
}
else{
out.println("Invalid password or username.");
}
}
catch (Exception e) {
e.printStackTrace();
}
%>

