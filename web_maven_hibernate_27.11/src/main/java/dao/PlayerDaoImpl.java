package dao;

import org.hibernate.Session;
import static utils.HibernateUtils.*;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;

public class PlayerDaoImpl implements PlayerDao {
	@Override
	public String addNewPlayer(Player player, Integer teamId) {

		String mesg = "Could Not Add New Player !!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			Team team = session.get(Team.class, teamId);
			if (team != null) {
				team.addPlayer(player);
				System.out.println("added player to the team");
			}
			tx.commit();
			mesg = "Added New Player with Id: " + player.getId() + " !!";

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}
}
