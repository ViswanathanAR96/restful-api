package myRestApi;

import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserItem {
	@Id
	private int userId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	
	public UserItem(int userId, String firstName, String lastName, String phoneNumber, String emailAddress) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----- Employee Information-----\n");
        sb.append("ID: " + getUserId() + "\n");
        sb.append("Name: " + getFirstName() + getLastName() + "\n");
        sb.append("Phone Number: " + getPhoneNumber() + "\n");
        sb.append("Email Address: " + getEmailAddress() + "\n");
        sb.append("*****************************");
        return sb.toString();
	}
	
}
