package Gestion_defis;



import javax.ejb.Remote;
@Remote

public interface Set_defisapply {
	public void createdefisapply(int from_userId,int to_userId);

}
