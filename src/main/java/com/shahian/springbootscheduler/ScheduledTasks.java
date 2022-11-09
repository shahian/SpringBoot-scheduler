package com.shahian.springbootscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
            "MM/dd/yyyy HH:mm:ss");

    @Scheduled(fixedRate = 100000)
    public void performTask() throws MessagingException {
        //Gmail Host
        String userName = "uspalangirani.shahian@gmail.com";
        //Enter your Gmail password
        String password = "***********";
        System.out.println("start send mail at "
                + dateFormat.format(new Date()));


        // Recipient's email ID needs to be mentioned.
        String to = "hamidreza.shahian@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "uspalangirani.shahian@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        //Session session = Session.getDefaultInstance(properties);
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(userName, password);

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is a test  message with schedule ");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
// *** END CHANGE
        System.out.println("the mail was sent at  "
                + dateFormat.format(new Date()));
    }

//another example
    @Scheduled(initialDelayString = "${application.scheduler.initialDelay.value}", fixedRateString = "${application.scheduler.fixedRate.value}")
    public void performDelayedTask() {

        System.out.println("Delayed Regular task performed at "
                + dateFormat.format(new Date()));

    }
    //another example 
    @Scheduled(cron = "*/5 * * * * *")
    public void performTaskUsingCron() {

        System.out.println("Regular task performed using Cron at "
                + dateFormat.format(new Date()));

    }
}
