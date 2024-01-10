package com.demo.messagebean;

import java.io.Serializable;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.demo.entitybean.Book;
import com.demo.entitybean.LibraryPersistentBeanRemote;

/**
 * Message-Driven Bean implementation class for: LibraryMessageBean
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "queue/TestQueue"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "queue/TestQueue")
public class LibraryMessageBean implements MessageListener {

	@Resource
	   private MessageDrivenContext mdctx;  
	 
	   @EJB
	   LibraryPersistentBeanRemote libraryBean;
	 
	   public LibraryMessageBean() {        
	   }
	 
	   public void onMessage(Message message) {
	      ObjectMessage objectMessage = null;
	      int count = 1;
	      try {
	    	  if(message instanceof ObjectMessage) {
	    		  objectMessage = (ObjectMessage) message;
	 	         Book book = (Book) objectMessage.getObject(); 
	 	         libraryBean.addBook(book);
	 	         
	 	        Serializable object = objectMessage.getObject();
	 	 		Book b = (Book) object;
	 	 		System.out.println("Id : "+b.getId() + "Name : "+b.getName());
	    	  }
	    	  else {
	    		  TextMessage textMessage = (TextMessage)message;
	    		  System.out.println("Recieved message with content : "+textMessage.getText());
	    	  }
	         
	      } catch (JMSException ex) {
	         mdctx.setRollbackOnly();
	      }  
	   }
}
