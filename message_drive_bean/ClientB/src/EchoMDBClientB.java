import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sun.messaging.jms.ra.ConnectionCreator;



public class EchoMDBClientB implements MessageListener {

	/**
	 * @param args
	 * @throws NamingException 
	 * @throws JMSException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws JMSException, NamingException, IOException {
		// TODO Auto-generated method stub
		EchoMDBClientB echoMDBClientB = new EchoMDBClientB();
		Context context = EchoMDBClientB.getInitialContext();
		Queue queue03 =(Queue)context.lookup("Queue03");
		Queue queue04 =(Queue)context.lookup("Queue04");
		
		JMSContext jmsContext03 =  ((ConnectionFactory)context.lookup("GFConnectionFactory")).createContext();
        jmsContext03.createConsumer(queue03).setMessageListener(echoMDBClientB);//监听queue03
        JMSProducer jmsProducer =jmsContext03.createProducer();//建立发送者
        BufferedReader bufferedReader =new java.io.BufferedReader(new InputStreamReader(System.in));
        String messageToSend = null;
        System.out.println("you are now connected...");
        while(true){
        	messageToSend = bufferedReader.readLine();
        	if(messageToSend.equalsIgnoreCase("exit")){
        		jmsContext03.close();
        		System.out.println("goodbye");
        		System.exit(0);
        		
        	}else{
        		jmsProducer.send(queue04, messageToSend);//始终给04上发
        		
        	}
        	
        }
	}

	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			System.out.println(message.getBody(String.class));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Context getInitialContext() throws JMSException, NamingException{
		Properties properties =new Properties();
		properties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		properties.setProperty("java.naming.factory.url.pkgs","com.sun.enterprise.naming");
		properties.setProperty("java.naming.provider.url", "iiop://localhost:3700");
		return new InitialContext(properties);

		
		
	}

}