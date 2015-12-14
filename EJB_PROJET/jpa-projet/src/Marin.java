
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Marin database table.
 * 
 */
@Entity(name="Marin")
@Table(name="Marin")
public class Marin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String mdp;

	private int record;

	private String uid;

    public Marin() {
    }
    
    public Marin(int id,String uid,String mdp, int record){
    	this.id=id;
    	this.uid=uid;
    	this.mdp=mdp;
    	this.record=record;
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getRecord() {
		return this.record;
	}

	public void setRecord(int record) {
		this.record = record;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}