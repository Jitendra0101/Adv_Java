package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

/**
 * Servlet implementation class AddPlayer
 */
@WebServlet("/add_player")
public class AddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try (PrintWriter pw = response.getWriter()) {

			HttpSession session = request.getSession();

			String firstName = request.getParameter("nm");
			String lastName = request.getParameter("lm");
			Date dob = Date.valueOf(request.getParameter("dob"));
			String abbrev = request.getParameter("abbrevation");
			double avg = Double.parseDouble(request.getParameter("avg"));
			int wickets = Integer.parseInt(request.getParameter("wickets"));

			LocalDate date = dob.toLocalDate();
			int age = Period.between(date, LocalDate.now()).getYears();

			TeamDaoImpl teamDao = (TeamDaoImpl) session.getAttribute("team_dao");
			PlayerDaoImpl playerDao = (PlayerDaoImpl) session.getAttribute("player_dao");

			Team team = teamDao.getTeamDetails(abbrev);

//			if(age>=team.getMaxAge()) {
//				pw.print("<h5></h5>")
//			}

			if (age <= team.getMaxAge() && team.getMinBattingAvg() <= avg && team.getMinWicketsTaken() <= wickets) {

				playerDao.addPlayerToTeam(new Player(firstName, lastName, dob, avg, wickets, team.getTeamId()),
						team.getTeamId());
				System.out.println("player is added successfully !!!");
			}

			System.out.println("player was NOT added !!!");
			pw.print("<h5>Player Does NOT meet requirements !!! </h5>");

		} catch (Exception e) {

			throw new ServletException("error in " + getClass(), e);
		}

	}

}
