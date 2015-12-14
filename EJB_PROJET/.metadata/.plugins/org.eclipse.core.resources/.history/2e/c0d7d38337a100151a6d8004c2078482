

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: list_friendapply
 *
 */
@Entity(name="List_friendapply")
@Table(name="list_friendapply")

public class List_friendapply implements Serializable {

	   
	@Id
	private int id;
	private int to_userId;
	private int from_userId;
	private Date date;
	private byte isRead;
	private static final long serialVersionUID = 1L;

	public List_friendapply() {
		super();
	}
    public List_friendapply(int from_userId,int to_userId) {
    	this.from_userId=from_userId;
    	this.to_userId=to_userId;
    	this.isRead=0;
    	date = new java.sql.Date(System.currentTimeMillis());
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getTo_userId() {
		return this.to_userId;
	}

	public void setTo_userId(int to_userId) {
		this.to_userId = to_userId;
	}   
	public int getFrom_userId() {
		return this.from_userId;
	}

	public void setFrom_userId(int from_userId) {
		this.from_userId = from_userId;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public byte getIsRead() {
		return this.isRead;
	}

	public void setIsRead(byte isRead) {
		this.isRead = isRead;
	}
   
}
