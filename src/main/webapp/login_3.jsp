<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("user");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306";
String database = "bill";
String userid = "root";
String password = "8111";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>

<h1>Retrieve data from database in jsp</h1>
<table border="1">
<tr>
<td>first name</td>
<td>last name</td>
<td>City name</td>
<td>Email</td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from user";
resultSet = statement.executeQuery(sql);
//while(resultSet.next()){
    out.println("into while loop");
%>
<tr>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("password") %></td>

</tr>
<%
//}
connection.close();
} 
catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>
