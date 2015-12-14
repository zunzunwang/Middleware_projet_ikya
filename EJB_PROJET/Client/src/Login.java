import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;

import Gestion_ami.Verification;
import Gestion_ami.Verification_User_Account;

import java.awt.*;   
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame{
	JFrame logIN = new JFrame("Login");
	Container panel = logIN.getContentPane();
	JTextField jTextField =  new JTextField(50);
    JPasswordField jPasswordField = new JPasswordField(50);
    JLabel jLabel1 = new JLabel("UserAccount: ");
    JLabel jLabel2 = new JLabel("Password: ");
    JButton jb1 = new JButton("Register");
    JButton jb2 = new JButton("Confirm");
    
    public Login(){
      
		logIN.setContentPane(panel);
		logIN.getLayeredPane().setLayout(null);
		panel.setLayout(null);
        
        panel.add(jLabel1);
        jLabel1.setBounds(50, 20, 120, 25);
        
        panel.add(jTextField);
        jTextField.setBounds(175, 20, 200, 25);
        
        panel.add(jLabel2);
        jLabel2.setBounds(50, 80, 120, 25);
        
        panel.add(jPasswordField);
        jPasswordField.setBounds(175, 80, 200, 25);
        
        panel.add(jb1);
        jb1.setBounds(50, 140, 100, 20);
		jb1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent w) {
				// action de register
				logIN.dispose();
			    Logup myWindows = new Logup();
			}
		});
        
        panel.add(jb2);
        jb2.setBounds(275, 140, 100, 20);
		jb2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent w) {
				// action de confirm
				InitialContext context = null;
				try {
					context = new InitialContext();
					try {
						Verification verification = (Verification)context.lookup("Verification");
						Verification_User_Account verification_user_account = (Verification_User_Account)context.lookup("Verification_User_Account");
						
						String name = new String(jTextField.getText());
						String password = new String(jPasswordField.getPassword());
						if(verification_user_account.verification_user_account(name)){
							User user = (User) verification.verifierUser(name); 
							if(user.getUserPassword().equals(password)){
								int id = user.getUserId();			
								logIN.dispose();
								Windows myWindows = new Windows(id);
							}else{				
								JOptionPane.showMessageDialog(null, "This user don't exist or you input incorrect password", "ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(null, "This user don't exist or you input incorrect password", "ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
						}
					}catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			});
        
        logIN.setSize(400, 200);
        logIN.setLocationRelativeTo(null);
        logIN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logIN.setVisible(true);
        logIN.setResizable(false);
         
    }
    public static void main(String[] args){
        new Login();
    }
}