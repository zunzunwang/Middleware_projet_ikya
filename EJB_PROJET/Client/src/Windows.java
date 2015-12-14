import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.*;

import Gestion_ami.Allfriends;
import Gestion_ami.Delete_Friend;
import Gestion_ami.Demande_FriendsApply;
import Gestion_ami.Find_User;
import Gestion_ami.Get_friends;
import Gestion_ami.Id_Name;
import Gestion_defis.Demande_DefisApply;

public class Windows{
	String nameUser = null;
	String sexUser = null;
	String idUser = null;
	String emailUser = null;	

	JFrame fen = new JFrame("MainWindow");
	Container panel = fen.getContentPane();
	JTextField name = new JTextField("Identifiant");
	JButton add = new JButton("Ajouter");
	JButton delete = new JButton("Supprimer");
	JButton find = new JButton("Rechercher");
	JButton challenge = new JButton("Challenge");
	JButton record = new JButton("Record");
	JButton exit = new JButton("Exit");
	JLabel friendLab = new JLabel("Liste des friends");
	JLabel nameLab = new JLabel("Identifiant");
//	JTextArea friends = new JTextArea("");
	JList friends = null;
	JLabel info = new JLabel("Information detaillee:");
	JLabel nameFriend = new JLabel("Account: ");
	JLabel sexFriend = new JLabel("Sex: ");
	JLabel idFriend = new JLabel("ID: ");
	JLabel emailFriend = new JLabel("Email: ");
	
	JScrollPane friendScroll = new JScrollPane(friends);

	JPanel panel1 = new JPanel();

	@SuppressWarnings("unchecked")
	public Windows(final int userId) {
		final DefaultListModel myFriends = new DefaultListModel();

		InitialContext context=null;
		try {
			context = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Allfriends allfriends = null;
		try {
			allfriends = (Allfriends)context.lookup("Allfriends");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//输入用户的userId.
		
		List<Object> result = allfriends.allfriends(userId);
		for(int i=0; i<result.size(); i++){
			int index = (int)result.get(i);
			Get_friends getFriends = null;
			try {
				getFriends = (Get_friends)context.lookup("Get_friends");
				
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			User user = (User) getFriends.getFriends(index);

			//myFriends.addElement(user.getUserName());

////////////////////////////////////////////////////////////////////////////
			myFriends.addElement(user.getUserAccount());
//			System.out.println(user.getUserid()+user.getUseraccount()+user.getUsername()+
//					user.getUserpassword()+user.getUsersex()+user.getUseremail());
		}
		System.out.println(result.size());
		
		fen.setContentPane(panel);
		fen.getLayeredPane().setLayout(null);
		panel.setLayout(null);
		
		final JLabel nameUserInfo = new JLabel(nameUser);
		final JLabel sexUserInfo = new JLabel(sexUser);
		final JLabel idUserInfo = new JLabel(idUser);
		final JLabel emailUserInfo = new JLabel(emailUser);
		
        panel.add(nameUserInfo);
        nameUserInfo.setBounds(500, 100, 200, 20);
        panel.add(sexUserInfo);
        sexUserInfo.setBounds(500, 150, 200, 20);
        panel.add(idUserInfo);
        idUserInfo.setBounds(500, 200, 200, 20);
        panel.add(emailUserInfo);
        emailUserInfo.setBounds(500, 250, 200, 20);
		
		panel.add(name);
		name.setBounds(10, 40, 120, 20);
		panel.add(find);
		find.setBounds(10, 110, 120, 20);
		find.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				find.setToolTipText("Input le nom de votre ami que vous voulez trouver.");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent w) {
				// action de find
				InitialContext context3=null;
				try {
					context3 = new InitialContext();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Find_User findUser = null;
				try {
					findUser = (Find_User)context3.lookup("Find_User");
					
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				List<User> userList = findUser.finduser(name.getText());
				DefaultListModel myFriends = new DefaultListModel();
				myFriends.removeAllElements();
				String userFoundme = null;
				for(int users=0; users<userList.size();users++){
					myFriends.addElement(userList.get(users).getUserAccount());
					userFoundme = userList.get(users).getUserAccount();
					//System.out.println(userList.get(users).getUserName());
				}

				final JList friendFound = new JList(myFriends);
				
				panel.add(friendFound);
				friends.setVisible(false);
				friendFound.setBounds(160, 40, 240, 240);
				friendFound.setBorder(BorderFactory.createTitledBorder("Result Found: "));		
				
				
				Id_Name idname = null;
			    try {
					idname = (Id_Name)context3.lookup("Id_Name");
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    int idid = idname.idName(userFoundme);
			    Get_friends get = null;
			    try {
					get = (Get_friends)context3.lookup("Get_friends");
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    User userFind = (User) get.getFriends(idid);
				nameUserInfo.setText(userFoundme);	
			    sexUserInfo.setText(userFind.getUserSex());
			    idUserInfo.setText(String.valueOf(userFind.getUserId()));
			    emailUserInfo.setText(userFind.getUserEmail());
				//System.out.println(sexUser+idUser+emailUser+userFind.getUserName());

			}
		});
		
		
		panel.add(add);
		add.setBounds(10, 140, 120, 20);
		add.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				add.setToolTipText("Input le nom de votre ami que vous voulez ajouter.");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent w) {
				// action d'ajouter
				String newUser = JOptionPane.showInputDialog("Please input the name: "); 
//				myFriends.addElement(newUser);
				int id1, id2;
				id1 = userId;
				
				InitialContext context5=null;
				try {
					context5 = new InitialContext();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Id_Name idnamef = null;
				try {
					 idnamef = (Id_Name)context5.lookup("Id_Name");
					
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				id2 =  idnamef.idName(newUser);
				
				Demande_FriendsApply maDemande = null;
				try {
					 maDemande = (Demande_FriendsApply)context5.lookup("Demande_FriendsApply");
					
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				maDemande.demande_FriendsApply(id1, id2);
				
			}
				
		});
		
		panel.add(challenge);
		challenge.setBounds(10, 170, 120, 20);
		challenge.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				add.setToolTipText("Let's fight it!");

			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent w) {
				// action de challenge
				System.out.println(nameUser);
				int id3, id4;
				id3 = userId;
				
				InitialContext context6=null;
				try {
					context6 = new InitialContext();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Id_Name idnameff = null;
				try {
					 idnameff = (Id_Name)context6.lookup("Id_Name");
					
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				id4 =  idnameff.idName(nameUser);
				
				Demande_DefisApply maDemande = null;
				try {
					 maDemande = (Demande_DefisApply)context6.lookup("Demande_DefisApply");
					
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				maDemande.demande_DefisApply(id3, id4);
				
				
			}
				
		});
		
		panel.add(delete);
		delete.setBounds(10, 200, 120, 20);
		delete.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				delete.setToolTipText("Supprimer l'ami.");
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent w) {
				// action de supprimer			
				if(friends.getSelectedIndex()!=-1){
					String name = null;
					name = friends.getSelectedValue().toString();
					System.out.println(name);
					
					InitialContext context2=null;
					try {
						context2 = new InitialContext();
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Id_Name idName = null;
					try {
						idName = (Id_Name)context2.lookup("Id_Name");
						
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int id = idName.idName(name);
					Delete_Friend deleteFriend = null;
					try {
						deleteFriend = (Delete_Friend)context2.lookup("Delete_Friend");
						
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(id);
					deleteFriend.deleteFriend(userId, id);
					 
					
					myFriends.remove(friends.getSelectedIndex());
//					Object[] selectedvalues= friends.getSelectedValues();
					}
			}
		});
		
		panel.add(record);
		record.setBounds(10, 230, 120, 20);
		record.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				add.setToolTipText("Look the game record.");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent w) {
				// action de record
				new record();
			}
				
		});
		
		panel.add(exit);
		exit.setBounds(10, 260, 120, 20);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				delete.setToolTipText("Exit APP.");
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent w) {
				// action de exit.
				fen.dispose();
			}
		});


		friends = new JList(myFriends);
		friends.setBorder(BorderFactory.createTitledBorder("List of my friends: "));		
		panel1.add(friends);
		panel1.setLayout(new GridLayout(1,1));
		panel1.add(new JScrollPane(this.friends));
		panel.add(panel1);
		panel1.setBounds(160, 40, 240, 240);
		friends.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){

				nameUser = friends.getSelectedValue().toString();

				nameUserInfo.setText(nameUser);	
				InitialContext context4=null;
				try {
					context4 = new InitialContext();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Id_Name idname = null;
			    try {
					idname = (Id_Name)context4.lookup("Id_Name");
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    int idid = idname.idName(nameUser);
			    Get_friends get = null;
			    try {
					get = (Get_friends)context4.lookup("Get_friends");
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    User userFind = (User) get.getFriends(idid);
			    
			    sexUserInfo.setText(userFind.getUserSex());
			    idUserInfo.setText(String.valueOf(userFind.getUserId()));
			    emailUserInfo.setText(userFind.getUserEmail());
				//System.out.println(sexUser+idUser+emailUser+userFind.getUserName());
			}
		});

        panel.add(info);
        info.setFont(new java.awt.Font("Verdana", 1, 20));
        info.setBounds(420, 40, 300, 20);
        panel.add(nameFriend);
        nameFriend.setBounds(420, 100, 70, 20);
        panel.add(sexFriend);
        sexFriend.setBounds(420, 150, 70, 20);
        panel.add(idFriend);
        idFriend.setBounds(420, 200, 70, 20);
        panel.add(emailFriend);
        emailFriend.setBounds(420, 250, 70, 20);

		fen.dispose();
		fen.setSize(730, 350);
		fen.setLocationRelativeTo(null);
		fen.setVisible(true);
		fen.setResizable(false);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}

	public static void main(String[] args) {
		Windows fen = new Windows(1);
	}
}