package pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static utils.DBUtils.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import dao.PlayerDaoImpl;
import pojos.Player;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/addPlayer", loadOnStartup = 1)
public class AddPlayer extends HttpServlet {

	private PlayerDaoImpl playerDao;

	public void init() throws ServletException {

		System.out.println("in init of " + getClass());

		try {

			openConnection();

			playerDao = new PlayerDaoImpl();

		} catch (Exception e) {
			throw new ServletException("Error in init of " + getClass(), e);
		}

	}

	public void destroy() {
		System.out.println("in destroy of " + getClass());
		try {
			playerDao.cleanUp();
			closeConnection();
		} catch (Exception e) {

			throw new RuntimeException("err in destroy of " + getClass(), e);
		}
	}

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

		rs.setContentType("text/html");

		int teams = Integer.parseInt(rq.getParameter("teams"));
		String firstName = rq.getParameter("firstName");
		String lastName = rq.getParameter("lastName");
		Date dob = Date.valueOf(rq.getParameter("dob"));
		double battingAvg = Double.parseDouble(rq.getParameter("battingAvg"));
		int wickets = Integer.parseInt(rq.getParameter("wickets"));

		try (PrintWriter pw = rs.getWriter()) {

			Player player = new Player(firstName, lastName, dob, battingAvg, wickets, teams);

			String mesg = playerDao.addPlayerToTeam(player, playerDao);

			if (mesg == null) {
				pw.print(
						"<h4> player was Not added to the team for below given reason, please <a href ='addPlayerForm.html'>try again</a></h4>");

				switch (player.getError()) {
				case 0: 
					System.out.println("player could not be added due to unknown reason from SQL database !!!");
					pw.print("<h4> # SQL error !!!!!</h4>");
					break;
					
				case 1:
					System.out.println("Player is too old !!!!");
					pw.print("<h4> # player is too old for the team</h4>");
					break;

				default:
					break;
				}

			}

			else {

				System.out.println(mesg);

				HttpSession hs = rq.getSession();
				hs.setAttribute("player details", player);
				hs.setAttribute("player_dao", playerDao);

				rs.sendRedirect("welcome");

			}

		} catch (SQLException e) {

			throw new ServletException("Error in do-post" + getClass(), e);
		}

	}

}
