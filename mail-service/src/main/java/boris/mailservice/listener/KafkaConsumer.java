package boris.mailservice.listener;


import boris.mailservice.entity.User;
import boris.mailservice.util.MailConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class KafkaConsumer {

    @Autowired
    private MailConstructor mailConstructor;

    @Autowired
    private JavaMailSender mailSender;

/*
    @KafkaListener(topics = "confirmation_mail",groupId= "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
*/


    @KafkaListener(topics = "confirmation_mail_json", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(HttpServletRequest request, User user) {
        System.out.println("Consumed JSON Message: " + user);
        String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

        SimpleMailMessage email = mailConstructor.constructResetTokenEmail(appUrl,request.getLocale(),user);

        mailSender.send(email);
    }
}