package beans;

import java.sql.Date;
import java.time.LocalDate;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Player;

public class PlayerBean {

	private String myTeam;
	private String fn;
	private String ln;
	private String dob;
	private double avg;
	private int wickets;
	
	private PlayerDao playerDao;
	private TeamDao teamDao;

	public PlayerBean() {

		playerDao = new PlayerDaoImpl();
		teamDao = new TeamDaoImpl();
		System.out.println("new playerDao created...");

	}

	public TeamDao getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public String getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(String myTeam) {
		this.myTeam = myTeam;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public PlayerDao getPlayerDao() {
		return playerDao;
	}

	public void setPlayerDao(PlayerDaoImpl playerDao) {
		this.playerDao = playerDao;
	}

	public String addNewPlayer() {

		
		LocalDate date = (Date.valueOf(dob)).toLocalDate();
		return playerDao.addNewPlayer(new Player(fn, ln, date, avg, wickets),teamDao.getDetailsByAbbreviation(myTeam).getId());

	}

}
