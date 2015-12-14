package Gestion_ami;


import javax.ejb.Remote;

@Remote
public interface Get_friends<User> {
	public User getFriends(int userId);

}
