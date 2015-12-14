package Gestion_defis;

import javax.ejb.Remote;

@Remote
public interface Demande_DefisApply {
	public void demande_DefisApply(int from_userId,int to_userId);

}