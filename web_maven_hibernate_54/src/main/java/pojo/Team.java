package pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teams_tbl")
public class Team extends BaseEntity {

	private String name;
	@Column(length = 5, unique = true)
	private String abbreviation;
	private String owner;
	private int maxAge;
	private double minBattingAvg;
	private int minWicketsTaken;

	@OneToMany(mappedBy = "myTeam")
	private List<Player> players = new ArrayList<>();

	public Team() {

	}

	public Team(String name, String abbreviation, String owner, int maxAge, double minBattingAvg, int minWicketsTaken) {

		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getMinBattingAvg() {
		return minBattingAvg;
	}

	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}

	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}

	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}

	public void addPlayer(Player player) {
		players.add(player);
		player.setMyTeam(this);
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner + ", maxAge=" + maxAge
				+ ", minBattingAvg=" + minBattingAvg + ", minWicketsTaken=" + minWicketsTaken + "]";
	}

}
