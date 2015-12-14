package Gestion_ami;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface Find_User<User> {
	public List<User> finduser(String useraccount);

}
