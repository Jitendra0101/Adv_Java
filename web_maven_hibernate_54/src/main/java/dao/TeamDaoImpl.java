package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Team;

import static utils.HibernateUtils.*;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addNewTeam(Team team) {

		String msg = "adding new team Failed !!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {

			System.out.println("in add new team !!");
			session.persist(team);
			tx.commit();
			msg = "added new team with Id: " + team.getId();

		} catch (RuntimeException e) {

			if (tx != null)
				tx.rollback();
			throw e;

		}

		return msg;
	}

}
