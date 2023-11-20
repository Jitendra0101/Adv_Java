package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("In error servlet !!");

		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {

			HttpSession hs = request.getSession();

			ArrayList<String> errorlist = (ArrayList<String>) hs.getAttribute("errorCode");

			pw.print("Player Does NOT meet below given requirements !!!");

			if (errorlist != null) {

				for (String s : errorlist) {

					pw.print("<h5> * " + s + "</h5>");

				}
			} else
				pw.print("Session Tracking failed !!!!!!! No cookies.....");

		}

	}

}
