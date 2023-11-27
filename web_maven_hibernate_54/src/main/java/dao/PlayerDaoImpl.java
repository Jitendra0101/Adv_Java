package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Player;
import pojo.Team;

import static utils.HibernateUtils.*;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addPlayerDetails(Player player, long teamId) {

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {

			Team team = session.get(Team.class, teamId);
			System.out.println(team);
			if (team != null) {
				team.addPlayer(player);
				session.persist(player);
			}
			tx.commit();

		} catch (RuntimeException e) {

			if (tx != null)
				tx.rollback();
			throw e;

		}
		return "Player details added with Id: " + player.getId();
	}
}
