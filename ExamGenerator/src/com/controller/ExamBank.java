package com.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Exam;
import com.model.Question;
import com.model.Student;

/**
 * Servlet implementation class ExamBank
 */
@WebServlet(description = "Used to generate 5 question for each user", urlPatterns = { "/ExamBank" })
public class ExamBank extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Test.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        String name = req.getParameter("name");
        String sid = req.getParameter("sid");
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(sid)) {
                    RequestDispatcher rd = req.getRequestDispatcher("completed.jsp");
                    rd.forward(req, resp);
                    return;
                }
            }
        }
        Student stud = new Student(name, sid);
        Exam exam = new Exam(stud, Question.getSampleQuestions());
        req.getSession().setAttribute("exam", exam);
        req.getSession().setAttribute("startTime", LocalDateTime.now());
        RequestDispatcher rd = req.getRequestDispatcher("exam.jsp");
        rd.forward(req, resp);
    }


}
