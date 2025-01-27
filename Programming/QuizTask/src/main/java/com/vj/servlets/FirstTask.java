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
 * Servlet implementation class FirstTask
 */
public class FirstTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstTask() {
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
		out.print("1th Servlet");
		HttpSession session=request.getSession();
		String answer1 = request.getParameter("q1");
//		System.out.println(answer1);
		int score=0;
		if(answer1 != null)
		{
			if(answer1.equalsIgnoreCase("extends"))
			{
				score++;
				session.setAttribute("score", score);
				response.sendRedirect("second.jsp");
			}
			else
			{
				session.setAttribute("score", score);
				response.sendRedirect("second.jsp");
			}
				
				
		}
		else
		{
			session.setAttribute("score", score);
			response.sendRedirect("second.jsp");
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
