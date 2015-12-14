package mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.JMSContext;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;


/**
 * Message-Driven Bean implementation class for: EchoMDB pour client2
 * @param <JMSContext>
 *
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "Queue01"), 
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, 
		mappedName = "Queue01")
public class EchoMDB_toClientB implements MessageListener {
	@Inject JMSContext jmsContext;
	@Resource(mappedName="Queue03") Queue queue03;//clientB
	
    public void onMessage(Message message) {
		try {
	        String stringMessage;
			stringMessage = message.getBody(String.class);
	        System.out.println("EchoMDB received the following message:"+stringMessage);
	        jmsContext.createProducer().send(queue03,"ClientA: "+stringMessage);

		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

}