package com.vj.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FifthTask
 */
public class FifthTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FifthTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
//		out.print("5th Servlet");
		String answer5 = request.getParameter("q5");
		HttpSession session=request.getSession();
		int score=(int)session.getAttribute("score");
//		System.out.println(score);
		if(answer5 != null)
		{
			if(answer5.equalsIgnoreCase("Both a and b"))
			{
				score++;
				session.setAttribute("score", score);
				response.sendRedirect("ResultTask");
			}
			else
			{
				session.setAttribute("score", score);
				response.sendRedirect("ResultTask");
			}
		}
		else
		{
			session.setAttribute("score", score);
			response.sendRedirect("ResultTask");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
