package io.eventsmyppl.domain;

import javax.persistence.*;

// User Profile: User name
@Entity
@Table(name="user")
public class UserProfile {
//User's Actual Name or the Name they want to use. Email is used for sign in.
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

private String userName;
//User's email used for sign in
 private String userEmail;
 //User password
 private String userPass;
//user street address
 private String userStreet;
 //User's City
 private String userCity;
 //User's state/region/territory
 private String userTerritory;
 //User's Zip or postal code
 private String userZip;
 //User's Phone number
 private String userPhone;

	
 //Constructors
 public UserProfile() {}

 public UserProfile(String userName, String userEmail, String userPass){
 	super();
 	this.userName = userName;
 	this.userEmail = userEmail;
 	this.userPass = userPass;
 }

 public UserProfile(long id,String userName, String userEmail, String userPass, String userStreet, String userCity, String userTerritory, String userZip, String userPhone) {
	 super();
	 this.id = id;
	 this.userName = userName;
	 this.userEmail = userEmail;
	 this.userPass = userPass;
	 this.userStreet = userStreet;
	 this.userCity = userCity;
	 this.userTerritory = userTerritory;
	 this.userZip = userZip;
	 this.userPhone = userPhone;
	 
 	}//basic constructor
 
 //Setters Getters

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

public String getUserStreet() {
	return userStreet;
}
public void setUserStreet(String userStreet) {
	this.userStreet = userStreet;
}

public String getUserCity() {
	return userCity;
}
public void setUserCity(String userCity) {
	this.userCity = userCity;
}

public String getUserTerritory() {
	return userTerritory;
}
public void setUserTerritory(String userTerritory) {
	this.userTerritory = userTerritory;
}

public String getUserZip() {
	return userZip;
}
public void setUserZip(String userZip) {
	this.userZip = userZip;
}

public String getUserPhoneNo() {
	return userPhone;
}
public void setUserPhoneNo(String userPhoneNo) {
	this.userPhone = userPhoneNo;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((userCity == null) ? 0 : userCity.hashCode());
	result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
	result = prime * result + ((userName == null) ? 0 : userName.hashCode());
	result = prime * result + ((userPhone == null) ? 0 : userPhone.hashCode());
	result = prime * result + ((userStreet == null) ? 0 : userStreet.hashCode());
	result = prime * result + ((userTerritory == null) ? 0 : userTerritory.hashCode());
	result = prime * result + ((userZip == null) ? 0 : userZip.hashCode());
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
	if (userCity == null) {
		if (other.userCity != null)
			return false;
	} else if (!userCity.equals(other.userCity))
		return false;
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
	if (userTerritory == null) {
		if (other.userTerritory != null)
			return false;
	} else if (!userTerritory.equals(other.userTerritory))
		return false;
	if (userZip == null) {
		if (other.userZip != null)
			return false;
	} else if (!userZip.equals(other.userZip))
		return false;
	return true;
}
 
 
 
}//Class
