<%-- 
    Document   : questionPage
    Author     : Befrdu Gebreamlack
--%>

<%@page import="com.model.Question"%>
<%@page import="com.model.Exam"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>quiz</title>
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            .radio{
                padding-left: 3em;
            }
        </style>
    </head>
    <body>
        <div class="container form-horizontal">

            <div class="panel panel-default">
                <div class="panel-heading"><h1>Exam Questions: </h1></div>
                <div class="panel-body">
                    <% Exam exam = (Exam) session.getAttribute("exam");
                        Question question = exam.nextQuestion();
                    %>
                    <%if (question == null) {
                            session.setAttribute("exam", exam);
                    %>
                    <jsp:forward page="result.jsp"/>
                    <%} else {
                        session.setAttribute("question", question);
                    %>
                    <p>Question: <%=question.getQuestion()%><br></p>
                    <form method="post" action="ExamManager">
                        <div class="form-group">
                            <% for (String choice : question.getChoices()) {%>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="answer" value="<%=choice%>"/>
                                    <%=choice%>
                                </label>
                            </div>
                            <%}%>
                            <div class="form-group"> 
                                <div class="col-sm-offset-2 col-sm-10">
                                    <input type="submit" class="btn btn-default" value="submit"/>
                                </div>
                            </div>
                        </div>
                    </form>
                    <%}%>
                </div>
            </div>
        </div>
    </body>
</html>
