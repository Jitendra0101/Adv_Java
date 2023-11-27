package test;

import java.util.Scanner;
import static utils.HibernateUtils.*;
import org.hibernate.SessionFactory;

import dao.TeamDaoImpl;
import pojo.Team;


public class AddNewTeamTester {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()){
			
			TeamDaoImpl teamDao = new TeamDaoImpl();
			System.out.println("Enter new team details:\n# firstName  # abbreviation  # owner  # max-age(int)\n"
													  + "# min-batting-avg(double)  # min-wickets-taken(int) :");
			Team team = new Team(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
			String mesg = teamDao.addNewTeam(team);
			System.out.println(mesg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
