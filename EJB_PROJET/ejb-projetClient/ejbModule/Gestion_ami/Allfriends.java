package Gestion_ami;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface Allfriends {
	public List<Object> allfriends(int userId);

}
