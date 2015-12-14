package mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;

/**
 * Message-Driven Bean implementation class for: EchoMDB2
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "Queue04"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "Queue04")
public class EchoMDB_toClientA implements MessageListener {
	@Inject JMSContext jmsContext03;
	@Resource(mappedName="Queue02") Queue queue02;//clientA

    public void onMessage(Message message) {
		try {
	        String stringMessage;
			stringMessage = message.getBody(String.class);
	        System.out.println("EchoMDB received the following message:"+stringMessage);
	        jmsContext03.createProducer().send(queue02,"ClientB: "+stringMessage);

		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
