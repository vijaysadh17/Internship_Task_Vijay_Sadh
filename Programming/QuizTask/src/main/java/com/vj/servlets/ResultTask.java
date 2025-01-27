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
 * Servlet implementation class ResultTask
 */
public class ResultTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultTask() {
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
		HttpSession session=request.getSession();
		int score= (int) session.getAttribute("score");
//		out.print(score);
		  out.println("<!DOCTYPE html>");
	        out.println("<html lang='en'>");
	        out.println("<head>");
	        out.println("<meta charset='UTF-8'>");
	        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
	        out.println("<title>Quiz Result</title>");
	        
	        out.println("<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css' rel='stylesheet'>");
	        out.println("<style>");
	        out.println("body { font-family: Arial, sans-serif; padding: 20px; background-color: #f4f4f9; }");
	        out.println(".result-container { max-width: 500px; margin: auto; padding: 20px; background-color: white; border-radius: 8px; box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1); }");
	        out.println(".result-header { font-size: 24px; font-weight: bold; text-align: center; margin-bottom: 20px; }");
	        out.println(".result-score { font-size: 18px; text-align: center; margin-top: 10px; }");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<body>");
	        
	     
	        out.println("<div class='result-container'>");
	        out.println("<div class='result-header'>Quiz Result</div>");
	        out.println("<p class='result-score'>Your Score: <span class='text-success'>" + score + "</span> out of 5</p>");
	        out.println("<a href='index.jsp' class='btn btn-primary btn-block'>Back to Quiz</a>");
			out.println("</div>");
	        
	       
	        out.println("<script src='https://code.jquery.com/jquery-3.5.1.slim.min.js'></script>");
	        out.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js'></script>");
	        out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
	        out.println("</body>");
	        out.println("</html>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
