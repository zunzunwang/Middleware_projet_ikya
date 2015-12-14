import javax.ejb.Remote;

@Remote
public interface MarinService {

   public long createMarin(int id,String uid, String mdp, int record) ;
}