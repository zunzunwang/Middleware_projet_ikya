

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;

import Gestion_ami.Set_friendapply;
import Gestion_defis.Set_defisapply;
@Stateless(mappedName = "Set_defisapply")
public class Set_defisapply_Impl implements Set_defisapply  {
	public Set_defisapply_Impl(){		
	}
	 @PersistenceContext
	 private EntityManager em ;

	@Override
	public void createdefisapply(int from_userId, int to_userId) {
		// TODO Auto-generated method stub
    
		 em.persist(new List_defisapply(from_userId,to_userId));
		 JOptionPane.showMessageDialog(null,"you have already passed the d�fis apply","Success", JOptionPane.WARNING_MESSAGE);
		 		 
	}

}
