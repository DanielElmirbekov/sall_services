package it_schoolkg.sall_services.Message.impl;

import it_schoolkg.sall_services.Message.SendSimpleMessage;
import it_schoolkg.sall_services.Message.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendSimpleMessageImpl implements SendSimpleMessage {


    @Autowired
    private JavaMailSenderImpl mailSender;

    public void sendSimpleMessage(String to, String text, Object mailSender){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("danielelmirbekov@gmail.com");
        message.setTo(to);
        message.setSubject("Код потверждения");
        message.setText("Ваш код потверждения: "+text);
    }
}
