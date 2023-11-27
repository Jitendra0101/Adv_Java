package beans;

import java.util.List;

import dao.TeamDaoImpl;

public class TeamBean {
// dependancy
	private TeamDaoImpl teamDao;

	public TeamBean() {

		System.out.println("in team bean");
		teamDao = new TeamDaoImpl();

	}

	public TeamDaoImpl getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDaoImpl teamDao) {
		this.teamDao = teamDao;
	}

	public List<String> fetchTeamsAbbreviations() {

		return teamDao.getAllTeamsAbbreviations();

	}

}
