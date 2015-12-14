package Gestion_ami;

import javax.ejb.Remote;

@Remote
public interface Verification_User_Account{

   public boolean verification_user_account(String userAccount) ;
}
