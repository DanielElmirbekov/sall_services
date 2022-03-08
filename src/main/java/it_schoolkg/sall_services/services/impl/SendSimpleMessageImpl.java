package it_schoolkg.sall_services.services.impl;

import it_schoolkg.sall_services.services.SendSimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendSimpleMessageImpl implements SendSimpleMessage {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendCode(String to, String text){
        SendSimpleMessage sendSimpleMessage = new SendSimpleMessage() {
        @Override
        public void sendCode(String to, String text) {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("danielelmirbekov29@gmail.com");
            simpleMailMessage.setTo(to);
            simpleMailMessage.setText("Ваш код потвержден :" + text);
            javaMailSender.send(simpleMailMessage);
            }
        };
    }
}