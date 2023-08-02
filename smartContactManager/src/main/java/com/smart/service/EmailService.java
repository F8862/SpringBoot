package com.smart.service;

import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
	
	public boolean sendEmail(String subject,String message,String to){

        boolean f=false;

        String from="furquanziya07@gmail.com";

        //variable for gmail host
        String host="smtp.gmail.com";

        //get the system properties
        Properties properties = System.getProperties();

        System.out.println("PROPERTIES"+ properties);

        //setting important information to properties object

        //host set
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //Step 1:To get the session object
        Session session= Session.getInstance(properties,new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("furquanziya07@gmail.com","kzhhmypxxqyrhabd");
            }

        });
        session.setDebug(true);
        //Step 2:Compose the message[text,multi media]
        MimeMessage m = new MimeMessage(session);
        try {
            //from mail
            m.setFrom(from);

            //adding Recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //adding subject to msg
            m.setSubject(subject);

            //adding text to msg
           // m.setText(message);
            m.setContent(message,"text/html");

            //Step 3:send msg using transport class
            Transport.send(m);
            System.out.println("Send sucessfully...");
            f=true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;


    }

}
