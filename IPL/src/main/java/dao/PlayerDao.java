package dao;

import java.sql.SQLException;

import pojos.Player;

public interface PlayerDao {
//add a method to add new player to the team
	String addPlayerToTeam(Player newPlayer, PlayerDao playerDao) throws SQLException;
	
	Player authenticatePlayer(Player newPlayer) throws SQLException;
}
