package io.eventsmyppl.domain;

import javax.persistence.*;

// User Profile: User name
@Entity
@Table(name="users")
public class UserProfile {
//User's Actual Name or the Name they want to use. Email is used for sign in.
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name = "username")
private String userName;
//User's email used for sign in
@Column(name = "email") 
private String userEmail;
 //User password
@Column(name="password")
 private String userPass;
//user street address 
//TODO - Separate Address Table. Considerations based on research:
//1. Using "junction" table for address to user relation. 2. Using Lookup table for city state, country, zip for consistency. 
@Column (name = "address")
 private String userStreet;
//user phone number
@Column (name = "phone")
 private String userPhone;

	
 //Constructors
 public UserProfile() {}

 public UserProfile(String userName, String userEmail, String userPass){
 	super();
 	this.userName = userName;
 	this.userEmail = userEmail;
 	this.userPass = userPass;
 }

 public UserProfile(String userName, String userEmail, String userPass, String userStreet, String userPhone) {
	 super();
	 this.userName = userName;
	 this.userEmail = userEmail;
	 this.userPass = userPass;
	 this.userStreet = userStreet;

	 this.userPhone = userPhone;
	 
 	}//basic constructor
 
 //Setters Getters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getUserPass() {
	return userPass;
}
public void setUserPass(String userPass) {
	this.userPass = userPass;
}


public String getUserStreet() {
	return userStreet;
}
public void setUserStreet(String userStreet) {
	this.userStreet = userStreet;
}

public String getUserPhone() {
	return userPhone;
}
public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
	result = prime * result + ((userName == null) ? 0 : userName.hashCode());
	result = prime * result + ((userPhone == null) ? 0 : userPhone.hashCode());
	result = prime * result + ((userStreet == null) ? 0 : userStreet.hashCode());
	
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	UserProfile other = (UserProfile) obj;
	if (userEmail == null) {
		if (other.userEmail != null)
			return false;
	} else if (!userEmail.equals(other.userEmail))
		return false;
	if (userName == null) {
		if (other.userName != null)
			return false;
	} else if (!userName.equals(other.userName))
		return false;
	if (userPhone == null) {
		if (other.userPhone != null)
			return false;
	} else if (!userPhone.equals(other.userPhone))
		return false;
	if (userStreet == null) {
		if (other.userStreet != null)
			return false;
	} else if (!userStreet.equals(other.userStreet))
		return false;
	
	return true;
}
 
 
 
}//Class
