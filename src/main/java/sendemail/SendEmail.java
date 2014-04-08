package sendemail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	public static void main(String[] args) {
		new SendEmail(args[0],args[1],args[2],args[3],args[4]);
	}
   public SendEmail(String host, String to, String from, String subject, String contents) {
	   if (host == null) {
		   host = "localhost";
	   }
      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         message.setSubject(subject);

         // Now set the actual message
         message.setText(contents);

         // Send message
         Transport.send(message);
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}