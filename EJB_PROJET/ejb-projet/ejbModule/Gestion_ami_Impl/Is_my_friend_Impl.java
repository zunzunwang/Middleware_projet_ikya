package Gestion_ami_Impl;

import java.util.Collection;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import Gestion_ami.Is_my_friend;

@Stateless(mappedName = "Is_my_friend")
public class Is_my_friend_Impl<List_contact> implements Is_my_friend{
	public Is_my_friend_Impl(){
	}

	 @PersistenceContext
	 private EntityManager em ;

	@Override
	public boolean is_myfriend(int from_userId, int to_userId) {
		// TODO Auto-generated method stub
		String qlString_1="SELECT e FROM List_contact e WHERE e.userId1 = :from_userId AND e.userId2 = :to_userId ";
		String qlString_2="SELECT e FROM List_contact e WHERE e.userId1 = :to_userId AND e.userId2 = :from_userId";
		Query query_1 = em.createQuery(qlString_1);
		Query query_2 = em.createQuery(qlString_2);
		query_1.setParameter("from_userId", from_userId);
		query_1.setParameter("to_userId", to_userId);
		query_2.setParameter("from_userId", from_userId);
		query_2.setParameter("to_userId", to_userId);
		Collection<List_contact> list_contact_1= (Collection<List_contact>)query_1.getResultList();
		Collection<List_contact> list_contact_2= (Collection<List_contact>)query_2.getResultList();

		if(list_contact_1.isEmpty()&&list_contact_2.isEmpty()){
			System.out.println("no");
			return false;
		}else{
			JOptionPane.showMessageDialog(null,"you have already added this friend","Alert", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		

	}

}