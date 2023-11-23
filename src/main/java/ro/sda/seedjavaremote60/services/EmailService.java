package ro.sda.seedjavaremote60.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String to, String from, String subject, String notes) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@app.com");
        message.setCc(from);
        message.setTo("contact@gmail.com");
        message.setSubject(subject);
        message.setText(to + notes);
        emailSender.send(message);
    }
}