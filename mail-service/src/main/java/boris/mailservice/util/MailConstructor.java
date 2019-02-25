package boris.mailservice.util;

import boris.mailservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MailConstructor {
    @Autowired
    private Environment env;


    public SimpleMailMessage constructResetTokenEmail(
            String contextPath, Locale locale, User user
    ) {

        String url = contextPath + "/newUser";
        String message = "\nPlease click on this link to verify your email \n";
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getMail());
        email.setSubject("New User");
        email.setText(url + message);
        email.setFrom(env.getProperty("support.email"));
        return email;

    }
}