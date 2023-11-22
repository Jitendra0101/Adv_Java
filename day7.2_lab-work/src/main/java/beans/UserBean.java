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
	// clnt info
	private String email;
	private String pass;
	private String fn;
	private String ln;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	// add a B.L method to authenticate user
	public String authenticateUser() throws SQLException {
		System.out.println("in JB B.L auth user " + email + " " + pass);
		// JB ---> DAo's method
		userDetails = userDao.authenticateUser(email, pass);
		if (userDetails == null) // => invalid login
			return "login"; // JB rets dyn navigational outcome (i.e telling JSP where to take the clnt
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
		LocalDate date = LocalDate.parse(dob);
		int age = Period.between(date, LocalDate.now()).getYears();
		
		if(age<21)//not a valid user !!
			return "You are too young !! \nAge should be greater than 20";
		
		return userDao.registerNewVoter(new User(fn,ln,email,pass,dateInDate));
		
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
}
