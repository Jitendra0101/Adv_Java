package pojo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players_tbl")
public class Player extends BaseEntity {

	private String firstName;
	private String lastName;
	private Date dob;
	private double battingAvg;
	private int wicketsTaken;

	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team myTeam;

	public Player() {
	}

	public Player(String firstName, String lastName, Date dob, double battingAvg, int wicketsTaken) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	public Team getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(Team myTeam) {

		this.myTeam = myTeam;

	}

	@Override
	public String toString() {
		return "Player [playerId=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", battingAvg="
				+ battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
	
}
