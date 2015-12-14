package Gestion_ami;

import javax.ejb.Remote;

@Remote
public interface Is_Online{

   public boolean is_online(int userId) ;
}
