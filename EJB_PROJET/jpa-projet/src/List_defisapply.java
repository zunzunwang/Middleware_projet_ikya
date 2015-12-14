

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: List_defisapply
 *
 */
@Entity
@Table(name="list_defisapply")

public class List_defisapply implements Serializable {

	   
	@Id
	private int id;
	private int from_userId;
	private int to_userId;
	private Date date;
	private boolean isRead;
	private static final long serialVersionUID = 1L;

	public List_defisapply() {
		super();
	}
	public List_defisapply(int from_userId,int to_userId) {
    	this.from_userId=from_userId;
    	this.to_userId=to_userId;
    	this.isRead=false;
    	date = new java.sql.Date(System.currentTimeMillis());
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getFrom_userId() {
		return this.from_userId;
	}

	public void setFrom_userId(int from_userId) {
		this.from_userId = from_userId;
	}   
	public int getTo_userId() {
		return this.to_userId;
	}

	public void setTo_userId(int to_userId) {
		this.to_userId = to_userId;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public boolean getIsRead() {
		return this.isRead;
	}

	public void setIsRead(boolean isRead) {
		this.isRead = isRead;
	}
   
}
