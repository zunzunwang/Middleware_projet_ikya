package Gestion_ami;


import javax.ejb.Remote;
@Remote

public interface Set_friendapply {
	public void createfriendapply(int from_userId,int to_userId);

}
