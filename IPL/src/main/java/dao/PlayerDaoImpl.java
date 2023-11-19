package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import static utils.DBUtils.*;

import pojos.Player;

public class PlayerDaoImpl implements PlayerDao {

	private Connection cn;
	private PreparedStatement pst1,pst2;

	public PlayerDaoImpl() throws SQLException {

		cn = getCn();
		pst1 = cn.prepareStatement("insert into players values(default,?,?,?,?,?,?)");
		pst2 = cn.prepareStatement("select max_age from teams where team_id = ?");
		System.out.println("player Dao created");

	}

	@Override
	public String addPlayerToTeam(Player newPlayer, PlayerDao playerDao) throws SQLException {
		
		System.out.println("in addPlayerToTeam !!!!!!");

		Player player = playerDao.authenticatePlayer(newPlayer);
		System.out.println("coming back from authenticatePlayer, value of player here is: " + player);

		if (player == null)
			return null;
			

		pst1.setString(1, newPlayer.getFirstName());
		pst1.setString(2, newPlayer.getLastName());
		pst1.setDate(3, newPlayer.getDob());
		pst1.setDouble(4, newPlayer.getBattingAvg());
		pst1.setInt(5, newPlayer.getWicketsTaken());
		pst1.setInt(6, newPlayer.getTeamId());

		int rst = pst1.executeUpdate();

		if (rst != 0)
			return "player Successfully added !!!";

		return null;

	}

	@Override
	public Player authenticatePlayer(Player newPlayer) throws SQLException {
		
		System.out.println("In authenticatePlayer !!!");

		LocalDate date = newPlayer.getDob().toLocalDate();
		int ageOfPlayer = Period.between(date, LocalDate.now()).getYears();
		
		pst2.setInt(1, newPlayer.getTeamId());
		
		ResultSet rst = pst2.executeQuery();
		
		if(!rst.next())
			return null;
		
		if(ageOfPlayer > rst.getInt(1)) {
			newPlayer.setError(1);
			return null;
		}
		
//		ADD MORE VALIDATION RULES !!!!!!!!!

		return newPlayer;
	}

	public void cleanUp() throws SQLException {

		if (pst1 != null)
			pst1.close();
		System.out.println("team dao cleaned up !");

	}

}
