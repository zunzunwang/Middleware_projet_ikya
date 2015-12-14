

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import Gestion_ami.Demande_FriendsApply;
import Gestion_ami.Is_Online;
import Gestion_ami.Is_my_friend;
import Gestion_ami.Set_friendapply;
import Gestion_ami_Impl.Is_Online_Impl;
import Gestion_ami_Impl.Is_my_friend_Impl;
@Stateless(mappedName = "Demande_FriendsApply")
public class Demande_FriendsApply_Impl implements Demande_FriendsApply {
	public Demande_FriendsApply_Impl(){		
	}

	@Override
	public void demande_FriendsApply(int from_userId,int to_userId) {
		// TODO Auto-generated method stub
		   try {
			InitialContext context = new InitialContext();
			
			Is_my_friend Ismyfriend =(Is_my_friend)context.lookup("Is_my_friend");;
			if(Ismyfriend.is_myfriend(from_userId, to_userId)){
			}else{
				
				Is_Online ismyfriendOnline =(Is_Online)context.lookup("Is_Online"); ;
				if(ismyfriendOnline.is_online(to_userId)){
					JOptionPane.showMessageDialog(null,"He is online","Alert", JOptionPane.WARNING_MESSAGE);			
				}else{
					JOptionPane.showMessageDialog(null,"He is not online, we will passe a demande","Alert", JOptionPane.WARNING_MESSAGE);
					Set_friendapply  setfriendapply =(Set_friendapply)context.lookup("Set_friendapply");
					setfriendapply.createfriendapply(from_userId, to_userId);
				}
		} 
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
		


