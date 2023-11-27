package beans;

import java.util.ArrayList;
import java.util.List;

import dao.TeamDaoImpl;
import pojo.Player;
import pojo.Team;

public class TeamBean {

	private TeamDaoImpl teamDao;
	private Team team;
	private String name;
	private String abbreviation;
	private String owner;
	private int maxAge;
	private double minBattingAvg;
	private int minWicketsTaken;

	private List<Player> players = new ArrayList<>();

	public TeamBean() {
		teamDao = new TeamDaoImpl();
		System.out.println("team bean created...");
	}

	public TeamDaoImpl getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDaoImpl teamDao) {
		this.teamDao = teamDao;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getMinBattingAvg() {
		return minBattingAvg;
	}

	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}

	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}

	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public String addTeam() {

		Team team = new Team(name, abbreviation, owner, maxAge, minBattingAvg, minWicketsTaken);
		System.out.println(team);
		String msg = teamDao.addNewTeam(team);
		return msg;

	}
	
}
