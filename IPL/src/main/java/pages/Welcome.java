package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Player;


@SuppressWarnings("serial")
@WebServlet("/welcome")
public class Welcome extends HttpServlet{
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
		
		System.out.println("in welcome servlet");
		rs.setContentType("text/html");
		
		try(PrintWriter pw = rs.getWriter()){
			
			HttpSession hs = rq.getSession();
			
			Player player = (Player) hs.getAttribute("player details");
			
			if(player != null)
				pw.print("Welcome to the team " + player.getFirstName());
			
			else
				pw.print("<h4> Session Tracking failed !!!!!!! No cookies.....</h4>");
			
		}
		
	}

}
