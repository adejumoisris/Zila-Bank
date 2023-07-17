package com.bank.banksystem.service.impl;

import com.bank.banksystem.dto.request.EmailDetails;
import com.bank.banksystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImp implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") // this is use to access the application.properties file which is the sender
    private String senderEmail;

    @Override
    public void sendEmailAlert(EmailDetails emailDetails) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(senderEmail); // this is the person sending the mail
            mailMessage.setTo(emailDetails.getRecipient()); // this is where the mail is going to
            mailMessage.setText(emailDetails.getMessageBody()); // this is the body of the message
            mailMessage.setSubject(emailDetails.getSubject()); // this is the subject of the mail
            javaMailSender.send(mailMessage);
            System.out.println("mail sent successfully");
        } catch (MailException e) {
            throw new RuntimeException(e);
        }

    }
}
