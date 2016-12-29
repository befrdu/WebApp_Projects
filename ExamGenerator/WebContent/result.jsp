
<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.model.Exam"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <% Exam exam = (Exam) session.getAttribute("exam");
            LocalDateTime startTime = (LocalDateTime) session.getAttribute("startTime");
            long difference = ChronoUnit.SECONDS.between(startTime, LocalDateTime.now());
        %>   
        <div class="container form-horizontal">

            <div class="panel panel-default">
                <div class="panel-heading"><h1>Exam Result: </h1></div>
                <div class="panel-body">
                    <dl class="dl-horizontal">
                        <dt>Name :</dt><dd> ${exam.student.name}</dd>
                        <dt>Student ID :</dt><dd> ${exam.student.id}</dd>
                        <dt>Total Score :</dt><dd> ${exam.score}</dd> 
                        <dt>Total Time :</dt><dd> <%=difference%> Seconds</dd>
                    </dl>
                </div>
            </div>
        </div>
        <%
            Cookie cookie
                    = new Cookie(exam.getStudent().getId(),
                            exam.getStudent().getName());
            response.addCookie(cookie);
        %>
    </body>
</html>
