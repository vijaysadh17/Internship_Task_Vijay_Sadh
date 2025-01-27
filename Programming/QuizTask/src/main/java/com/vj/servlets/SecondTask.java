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
 * Servlet implementation class SecondTask
 */
public class SecondTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondTask() {
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
//		out.print("2th Servlet");
		String answer2 = request.getParameter("q2");
		HttpSession session=request.getSession();
		int score=(int)session.getAttribute("score");
//		System.out.println(score);
		if(answer2 != null)
		{
			if(answer2.equalsIgnoreCase("SortedArray"))
			{
				score++;
				session.setAttribute("score", score);
				response.sendRedirect("third.jsp");
			}
			else
			{
				session.setAttribute("score", score);
				response.sendRedirect("third.jsp");
			}
		}
		else
		{
			session.setAttribute("score", score);
			response.sendRedirect("third.jsp");
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
