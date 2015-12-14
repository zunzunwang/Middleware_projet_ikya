package Gestion_ami;

import javax.ejb.Remote;

@Remote
public interface Verification<User>{
	public User verifierUser(String userAccount) ;
}