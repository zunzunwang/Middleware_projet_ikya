package Gestion_ami;

import javax.ejb.Remote;

@Remote
public interface Is_my_friend{

   public boolean is_myfriend(int from_userId,int to_userId) ;
}
