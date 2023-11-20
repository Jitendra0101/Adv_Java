package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

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

@WebServlet("/add_player")
public class AddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			ArrayList<String> errorList = new ArrayList<>();

			if (age <= team.getMaxAge() && team.getMinBattingAvg() <= avg && team.getMinWicketsTaken() <= wickets) {

				Player player = new Player(firstName, lastName, dob, avg, wickets, team.getTeamId());
				playerDao.addPlayerToTeam(player, team.getTeamId());
				System.out.println("player is added successfully !!!");
				session.setAttribute("player_details", player);
				response.sendRedirect("welcome");
			}

			if (age > team.getMaxAge()) {
				errorList.add("Player is too Old for the choosen team!!");
			}

			if (avg < team.getMinBattingAvg()) {
				errorList.add("Player does NOT meet minimum average Batting criteria for the choosen team!!");
			}

			if (wickets < team.getMinWicketsTaken()) {
				errorList.add("Player does NOT meet minimum Wickets taken criteria for the choosen team!!");
			}

			if (age > team.getMaxAge() || avg < team.getMinBattingAvg() || wickets < team.getMinWicketsTaken()) {
				session.setAttribute("errorCode", errorList);
				response.sendRedirect("ErrorServlet");
			}
		} catch (Exception e) {

			throw new ServletException("error in " + getClass(), e);
		}

	}

}
