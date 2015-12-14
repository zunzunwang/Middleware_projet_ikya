import java.rmi.RemoteException;
import java.util.Collection;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import Gestion_ami.Get_User_info;




public class isUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   try {
			 
			   InitialContext context = new InitialContext();
			   Get_User_info get_User_info = (Get_User_info)context.lookup("Get_User_info");


			   User user = new User();
			   user =  (User) get_User_info.get_user_info(0);
			   System.out.println(user.getUserId());
			   System.out.println(user.getUserName());

		      } catch (NamingException e) {
		         e.printStackTrace();
		      }
		   }

	

	private static boolean is_my_frend(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}
		
	}