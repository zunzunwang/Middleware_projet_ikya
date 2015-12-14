
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the List_contact database table.
 * 
 */
@Entity
public class List_contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_id")
	private int contactId;

	private int userId1;

	private int userId2;

    public List_contact() {
    }

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public int getUserId1() {
		return this.userId1;
	}

	public void setUserId1(int userId1) {
		this.userId1 = userId1;
	}

	public int getUserId2() {
		return this.userId2;
	}

	public void setUserId2(int userId2) {
		this.userId2 = userId2;
	}

}