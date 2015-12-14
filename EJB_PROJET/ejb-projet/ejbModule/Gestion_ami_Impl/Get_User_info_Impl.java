package Gestion_ami_Impl;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import Gestion_ami.Get_User_info;

@Stateless(mappedName = "Get_User_info")

public class Get_User_info_Impl<User> implements Get_User_info {
	
    @PersistenceContext
	private EntityManager em ;

	public User get_user_info(int userId) {
		// TODO Auto-generated method stub
		String qlString="SELECT e FROM User e WHERE e.userId =  :id";
		Query query = em.createQuery(qlString);		
		query.setParameter("id", userId);
		User user =(User)query.getSingleResult();
		return user;
	}

}
