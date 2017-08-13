<%-- 
    Document   : employee
    Created on : 13 Aug, 2017, 12:52:37 PM
    Author     : mvkr
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Employee Information</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                clearMessage();
                $("button a input textarea").on("click",function () {
                    clearMessage();
                });
                
                loadTable();
                $("#empForm").submit(function (e) {
                    var employee = {
                        "id": $("#rollno").val(),
                        "name": $("#name").val(),
                        "age": $("#age").val(),
                        "email": $("#email").val(),
                        "phoneNumber": $("#phoneNumber").val(),
                        "address": $("#address").val()
                    };
                    $.ajax({
                        type: "POST",
                        contentType: 'application/json; charset=utf-8',
                        dataType: 'json',
                        url: "/EmployeeInfo/employee/add",
                        data: JSON.stringify(employee), // Note it is important
                        success: function (result) {
                            alert(result);
                            if (result == "success") {
                                $("#message").slideDown();
                                $(".alert-success").show();
                                loadTable();
                            } else {
                                $("#message").slideDown();
                                $(".alert-danger").show();
                            }
                        },
                        error: function (error) {
                           $("#message").slideDown();
                                $(".alert-danger").show();
                        }
                    });
                    e.preventDefault();
                });



            });

            function empEdit(id) {
                $.ajax({
                    type: "GET",
                    contentType: 'application/json; charset=utf-8',
                    dataType: 'json',
                    url: "/EmployeeInfo/update/" + id,
                    success: function (result) {
                        if (result.length > 0) {
                            if (result[0].id != 0) {
                                $("#rollno").val(result[0].id);
                                $("#name").val(result[0].name);
                                $("#age").val(result[0].age);
                                $("#email").val(result[0].email);
                                $("#phoneNumber").val(result[0].phoneNumber);
                                $("#address").val(result[0].address);
                            }
                        }
                      
                    }
                });
            }
            function empDelete(id) {
                $.ajax({
                    type: "POST",
                    contentType: 'application/json; charset=utf-8',
                    url: "/EmployeeInfo/delete/" + id,
                    success: function (result) {
                        if (result == "success") {
                            $("#message").slideDown();
                            $(".alert-success").show();
                            loadTable();
                        } else {
                            $("#message").slideDown();
                            $(".alert-danger").show();
                        }

                    },
                        error: function (error) {
                           $("#message").slideDown();
                                $(".alert-danger").show();
                        }
                });
            }
            function loadTable() {

                $.ajax({
                    type: "GET",
                    contentType: 'application/json; charset=utf-8',
                    url: "/EmployeeInfo/employeeTable",
                    success: function (result) {
                        var i = 0;
                        var record = "";
                        for (i = 0; i < result.length; i++) {
                            if (result[i].id != 0) {
                                record += '<tr><td><button class="btn btn-primary" value="Edit" onclick="empEdit(' + result[i].id + ')"></button></td>\
                    <td><button class="btn btn-danger" value="Delete" onClick="empDelete(' + result[i].id + ')"></button></td><td>'
                                        + result[i].name
                                        + '</td><td>'
                                        + result[i].age
                                        + '</td><td>'
                                        + result[i].email
                                        + '</td><td>'
                                        + result[i].address
                                        + '</td><td>'
                                        + result[i].phoneNumber
                                        + '</td></tr>';
                            } else {
                                record += '<tr><td colspan="6">No Records found </td></tr>';
                            }
                        }

                        $("#emptable tbody").html(record);

                    },
                        error: function (error) {
                           $("#message").slideDown();
                                $(".alert-danger").show();
                        }
                });
            }
            function clearMessage() {
                $("#message").slideUp();
                $(".alert-success").hide();
                $(".alert-danger").hide();

            }
        </script>

    </head>
    <body>
        <div class="panel panel-default">
            <div class="panel-heading">Employee Information  </div>
            <div class="panel-body">
                <div class="row col-xs-12" id="message">
                    <div class=" alert alert-success margin-left" role="alert">
                        Data inserted successfully.
                    </div>
                    <div class=" alert alert-danger margin-left" role="alert">
                        Data inserted successfully.
                    </div>
                </div>
                    <div class="col-xs-6">
                        <form data-toggle="validator" role="form" id="empForm">
                            <div class="form-group">
                                <label for="rollno" class="control-label">roll No</label>
                                <input type="text" class="form-control" id="rollno" value="0" disabled>
                            </div>
                            <div class="form-group">
                                <label for="name" class="control-label">Name</label>
                                <input type="text" class="form-control" id="name" placeholder="Cina Saffary" required>
                            </div>
                            <div class="form-group">
                                <label for="age" class="control-label">Age</label>
                                <input type="text" class="form-control" id="age" placeholder="28" required>
                            </div>
                            <div class="form-group">
                                <label for="email" class="control-label">Email</label>
                                <input type="email" class="form-control" id="email" placeholder="xxx@yyy.com" data-error="Email address is invalid" required>
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <label for="phoneNumber" class="control-label">Phone Number</label>
                                <input type="tel" pattern="^\d{10}$" required id="phoneNumber" placeholder="7775555777" data-error="Mobile Number is invalid">
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <label for="comment">Address :</label>
                                <textarea class="form-control" rows="5" id="address"></textarea>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <button type="reset" class="btn btn-default">Reset</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-xs-6">
                        <table class="table" id="emptable">
                            <thead>
                                <tr>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                    <th>Name</th>
                                    <th>Age</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th>Phone Number</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td colspan="6">no record found</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        
    </body>
</html>
