

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "message", urlPatterns = { "/message" })
public class Message extends HttpServlet {   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if(session!=null){
			
			String uname = (String)session.getAttribute("uname");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("navbar.html");
			dispatcher.include(request, response);
			
			out.print("<H2 style = 'color:purple; padding-top:4px;'>Heyyy, "+uname+"</H2>"
					+ "<br/> <p>You have the best smile... Keep Smiling !!</p>");
			
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.include(request, response);
			out.print("<script>alert('!! WARNING : PLEASE LOG IN FIRST !!'); </script>");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
