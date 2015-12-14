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



public class EchoMDBClientA implements MessageListener {

	/**
	 * @param args
	 * @throws NamingException 
	 * @throws JMSException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws JMSException, NamingException, IOException {
		// TODO Auto-generated method stub
		EchoMDBClientA echoMDBClientA = new EchoMDBClientA();
		Context context = EchoMDBClientA.getInitialContext();
		Queue queue01 =(Queue)context.lookup("Queue01");//ClientA to ClientB 
		Queue queue02 =(Queue)context.lookup("Queue02");//Queue02 是clientA的队列

		JMSContext jmsContext =  ((ConnectionFactory)context.lookup("GFConnectionFactory")).createContext();
        jmsContext.createConsumer(queue02).setMessageListener(echoMDBClientA);//监听者
        JMSProducer jmsProducer =jmsContext.createProducer();//发送者
        BufferedReader bufferedReader =new java.io.BufferedReader(new InputStreamReader(System.in));
        String messageToSend = null;

        System.out.println("you are now connected...");
        while(true){
        	messageToSend = bufferedReader.readLine();
        	if(messageToSend.equalsIgnoreCase("exit")){
        		jmsContext.close();
        		System.out.println("goodbye");
        		System.exit(0);
        		
        	}else{
        		jmsProducer.send(queue01, messageToSend);//始终在01上发信息
        		
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
