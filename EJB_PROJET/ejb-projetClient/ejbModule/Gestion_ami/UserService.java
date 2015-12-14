package Gestion_ami;
import javax.ejb.Remote;

@Remote
public interface UserService{
	public String createUser(String userAccount, String userPassword, String userSex,
			String userEmail, String userName) ;
}
