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
 * Servlet implementation class ThirdTask
 */
public class ThirdTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThirdTask() {
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
//		out.print("3th Servlet");
		String answer3 = request.getParameter("q3");
		HttpSession session=request.getSession();
		int score=(int)session.getAttribute("score");
//		System.out.println(score);
		if(answer3 != null)
		{
			if(answer3.equalsIgnoreCase("protected"))
			{
				score++;
				session.setAttribute("score", score);
				response.sendRedirect("fourth.jsp");
			}
			else
			{
				session.setAttribute("score", score);
				response.sendRedirect("fourth.jsp");
			}
		}
		else
		{
			session.setAttribute("score", score);
			response.sendRedirect("fourth.jsp");
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
