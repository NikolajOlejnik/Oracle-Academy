<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Профиль пользователя ${user.name}</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
      <div class="panel panel-info">
        <div class="panel-heading">
          <h3 class="panel-title">Sheena Kristin A.Eschor</h3>
        </div>
        <div class="panel-body">
          <div class="row">
            <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png" class="img-circle img-responsive"> </div>
            <div class=" col-md-9 col-lg-9 ">
              <table class="table table-user-information">
                <tbody>
                <tr>
                  <td>Department:</td>
                  <td>Programming</td>
                </tr>
                <tr>
                  <td>Hire date:</td>
                  <td>06/23/2013</td>
                </tr>
                <tr>
                  <td>Date of Birth</td>
                  <td>01/24/1988</td>
                </tr>

                <tr>
                <tr>
                  <td>Gender</td>
                  <td>Male</td>
                </tr>
                <tr>
                  <td>Home Address</td>
                  <td>Metro Manila,Philippines</td>
                </tr>
                <tr>
                  <td>Email</td>
                  <td><a href="mailto:info@support.com">info@support.com</a></td>
                </tr>
                <td>Phone Number</td>
                <td>123-4567-890(Landline)<br><br>555-4567-890(Mobile)
                </td>

                </tr>

                </tbody>
              </table>

              <a href="#" class="btn btn-primary">My Sales Performance</a>
              <a href="#" class="btn btn-primary">Team Sales Performance</a>
            </div>
          </div>
        </div>
        <div class="panel-footer">
                        <span class="pull-right">

                        </span>
        </div>

      </div>
    </div>
  </div>
</div>
</body>
</html>
