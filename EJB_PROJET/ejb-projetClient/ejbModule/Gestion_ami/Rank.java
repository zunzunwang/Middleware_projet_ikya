package Gestion_ami;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface Rank<User> {
	public List<User> rank();

}
