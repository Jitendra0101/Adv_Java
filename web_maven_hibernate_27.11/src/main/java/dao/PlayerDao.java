package dao;

import pojos.Player;

public interface PlayerDao {
	String addNewPlayer(Player player, Integer teamId);
}
