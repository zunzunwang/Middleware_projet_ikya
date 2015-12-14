package Gestion_ami;

import javax.ejb.Remote;

@Remote
public interface Get_User_info<User> {
	public User get_user_info(int userId);

}
