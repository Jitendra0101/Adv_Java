package dao;

import pojo.Player;

public interface PlayerDao {

	String addPlayerDetails(Player player, long teamId);
	
}
