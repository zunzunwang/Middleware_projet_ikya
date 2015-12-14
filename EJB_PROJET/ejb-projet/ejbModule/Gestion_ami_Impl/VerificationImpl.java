package Gestion_ami_Impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import Gestion_ami.Verification;
//import Gestion_ami.Get_User_info;

@Stateless(mappedName = "Verification")
public class VerificationImpl<User> implements Verification {
	
    @PersistenceContext
	private EntityManager em ;

	public User verifierUser(String userAccount) {
		// TODO Auto-generated method stub
		String qlString="SELECT e FROM User e WHERE e.userAccount = " + "'" + userAccount + "'";
		Query query = em.createQuery(qlString);		
//		User user =(User)query.getSingleResult();
		User user = (User) query.getSingleResult();
		return user;

	}

}
