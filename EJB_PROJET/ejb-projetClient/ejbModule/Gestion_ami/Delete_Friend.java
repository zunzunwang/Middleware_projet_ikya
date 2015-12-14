package Gestion_ami;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface Delete_Friend {
	public void deleteFriend(int userId1, int userId2);

}
