package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Player;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In welcome servlet !!");
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter()){
			
			HttpSession hs = request.getSession();
			
			Player player = (Player) hs.getAttribute("player_details");
			
			if(player != null)
				pw.print("Welcome to the team " + player.getFirstName());
			
			else
				pw.print("Session Tracking failed !!!!!!! No cookies.....");
			
		}
		
		
	}

}
