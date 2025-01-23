package com.uptime.uptime_monitoring_alerting_system.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class AlertUtils {

    @Autowired
    private JavaMailSender mailSender;

    private static final String ALERT_EMAIL = "admin@example.com";

    public void sendAlert(String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(ALERT_EMAIL);
        mailMessage.setSubject("Uptime Alert: Service is Down");
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
