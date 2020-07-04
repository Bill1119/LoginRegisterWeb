<%@ page language="java" pageEncoding="gb2312"%>
<%@page import="java.sql.*,java.util.*"%>
<%
String user=request.getParameter("user");
String password=request.getParameter("password");
Class.forName("com.mysql.jdbc.Driver");

String url = "jdbc:mysql://localhost:3306/bill";
String userS = "root";
String passwordS = "8111";
Connection con = DriverManager.getConnection(url,userS,passwordS);

String sql_login = "select * from user";
PreparedStatement ps = con.prepareStatement(sql_login);
//ps.setString(1, user);
//ps.setString(2, password);
ResultSet rs = ps.executeQuery();

//Statement st= con.;
//ResultSet rs=st.executeQuery("SELECT * FROM user");
//out.println(rs.first());
if(rs == null)
{
out.println("rs is null");
}

//if(!con.isClosed())
%>
<!--<font size="+3" color="green"></*b>-->
<% 
//out.println("Successfully connected to " + "MySQL server using TCP/IP...");





try{


out.println(rs.getString("name"));
if(rs.getString("password").equals(password)&&rs.getString("name").equals(user))
{
out.println("Welcome " +user);
}
else{
out.println("Invalid password or username.");
    }

con.close();
    }
catch (Exception e) {
e.printStackTrace();
}
%>

