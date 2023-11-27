package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Team;

import static utils.HibernateUtils.*;

import java.util.List;

public class TeamDaoImpl implements TeamDao {
	@Override
	public String addNewTeam(Team team) {
		String msg = "adding new team failed!!!";
		// Get session from Sf
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(team);
			tx.commit();
			msg = "added new dept with id" + team.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public List<String> getAllTeamsAbbreviations() {
		
		List<String> abbreviations = null;
		String jpql = "select t.abbreviation from Team t";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction(); 
		try {
			abbreviations = session.createQuery(jpql, String.class).getResultList();
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return abbreviations;
	}

	@Override
	public Team getDetailsByAbbreviation(String abbrev) {
	
		Team team = null;
		String jpql = "select t from Team t where t.abbreviation =:abbr";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction(); 
		try {
			team = session.createQuery(jpql, Team.class).setParameter("abbr", abbrev).getSingleResult();
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return team;
	}
	
	

}