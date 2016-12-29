package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Exam;
import com.model.Question;

/**
 * Servlet implementation class ExamManager
 */
@WebServlet(description = "Used to manage the exam", urlPatterns = { "/ExamManager" })
public class ExamManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        Question question = (Question)req.getSession().getAttribute("question");
	        String answer = req.getParameter("answer");
	        Exam exam = (Exam)req.getSession().getAttribute("exam");
	        exam.answerQuestion(question, answer);
	        req.getSession().setAttribute("exam", exam);
	        req.getRequestDispatcher("exam.jsp").forward(req, resp);
	    }

}
