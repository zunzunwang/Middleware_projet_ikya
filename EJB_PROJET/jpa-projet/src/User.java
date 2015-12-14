

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="user")

public class User implements Serializable {

	   
	@Id
	private Integer userId;
	private String userAccount;
	private String userPassword;
	private String userSex;
	private String userEmail;
	private String userName;
	private boolean isOnline;
	private Integer userRecord;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}
	public User(String userAccount, String userPassword, String userSex,
			String userEmail, String userName) {
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userEmail = userEmail;
		this.userName = userName;
		this.isOnline =true;
		this.userRecord =0;
	}
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}   
	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}   
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}   
	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}   
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}   
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}   
	public Boolean getIsOnline() {
		return this.isOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}   
	public Integer getUserRecord() {
		return this.userRecord;
	}

	public void setUserRecord(Integer userRecord) {
		this.userRecord = userRecord;
	}
   
}
