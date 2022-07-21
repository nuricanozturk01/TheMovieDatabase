package com.company.internshipProject.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public final class Mail
{
    private final static String PASSWORD = "ycududogbumgjdda";
    private final static String EMAIL = "canozturk309@gmail.com";


    public static void sendMessage(String to,String subject,String text)
    {

        try
        {
            Properties properties = new Properties();
            properties.put("mail.smtp.auth","true");
            properties.put("mail.smtp.starttls.enable","true");
            properties.put("mail.smtp.host","smtp.gmail.com");
            properties.put("mail.smtp.port","587");
            properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(EMAIL, PASSWORD);
                }
            });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }
    }

}
