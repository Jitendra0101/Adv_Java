package beans;

import java.sql.Date;

import dao.PlayerDaoImpl;
import pojo.Player;

public class PlayerBean {

	private PlayerDaoImpl playerDao;
	private Player player;
	private Long teamId;
	private String teamAbr;
	private String firstName;
	private String lastName;
	private String dob;
	private double battingAvg;
	private int wicketsTaken;
	
	public PlayerBean() {
		playerDao = new PlayerDaoImpl();
	}

	public PlayerDaoImpl getPlayerDao() {
		return playerDao;
	}

	public void setPlayerDao(PlayerDaoImpl playerDao) {
		this.playerDao = playerDao;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeamAbr() {
		return teamAbr;
	}

	public void setTeamAbr(String teamAbr) {
		this.teamAbr = teamAbr;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	
	public String addNewPlayer() {
		
		System.out.println("in player bean --> in add new");
		Date sql_dob = Date.valueOf(dob);
		Player player = new Player(firstName, lastName, sql_dob, battingAvg, wicketsTaken);
		String mesg = playerDao.addPlayerDetails(player, teamId);
		
		return mesg;
	}

}
