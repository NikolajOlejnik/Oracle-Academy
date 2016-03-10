<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Registration</title>
</head>
<body>
<form method="get" action="add" commandName="userForm">
  <center>
    <table border="1" width="30%" cellpadding="5">
      <thead>
      <tr>
        <th colspan="2">Enter Information Here</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>Name</td>
        <td><input type="text" name="name" value="" /></td>
      </tr>
      <tr>
        <td>Login</td>
        <td><input type="text" name="login" value="" /></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="password" name="password" value="" /></td>
      </tr>
      <tr>
        <td>Email</td>
        <td><input type="text" name="email" value="" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="Submit" /></td>
        <td><input type="reset" value="Reset" /></td>
      </tr>
      <tr>
        <td colspan="2">Already registered? <a href="login.jsp">Login Here</a></td>
      </tr>
      </tbody>
    </table>
  </center>
</form>
</body>
</html>