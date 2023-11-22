package beans;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {
//props 
	private UserDaoImpl userDao;// dependency
	private User userDetails;// result
//	private User voterDetails;
	// clnamet info
	private String em;
	private String pass;
	private String fname;
	private String lname;
	private String dob;
	
	// def ctor
	public UserBean() throws SQLException {
		// create user dao instance
		userDao = new UserDaoImpl();
		System.out.println("user bean created...");
	}

	// generate getter n setter
	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	public String getEm() {
		return em;
	}

	public void setEm(String em) {
		this.em = em;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	// add a B.L method to authenticate user
	public String authenticateUser() throws SQLException {
		System.out.println("in JB B.L auth user " + em + " " + pass);
		// JB ---> DAo's method
		userDetails = userDao.authenticateUser(em, pass);
		if (userDetails == null) // => invalid login
			return "login"; // JB rets dyn navigational outcome (i.e telling JSP where to take the clnamet
							// next)
		//=> login successful
		if(userDetails.getRole().equals("admin"))
			return "admin_page";
		//=> voter 
		if(userDetails.isVotingStatus())
			return "logout";
		//=> voter not yet voter
		return "candidate_list";
	}
	//b.l. to add new voter
	public String registerNewVoter() throws SQLException {
		
		/*
		 * vaidate age --- invalid --- error mesg --- "cant register"
		 * if valid --- create user(voter) Instance --- invokes dao's method
		 * return status to the caller
		*/
		Date dateInDate = Date.valueOf(dob);
		int age = Period.between(LocalDate.parse(dob), LocalDate.now()).getYears();
		
		if(age<21)//not a valid user !!
			return "You are too young !! \nAge should be greater than 20";
		
		return userDao.registerNewVoter(new User(fname,lname,em,pass,dateInDate));
		
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
}
