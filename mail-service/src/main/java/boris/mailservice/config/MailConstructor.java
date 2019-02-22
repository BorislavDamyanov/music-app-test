package boris.mailservice.config;



import boris.mailservice.entity.User;
import groovy.text.TemplateEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;



import java.util.Locale;

@Component
public class MailConstructor {
    @Autowired
    private Environment env;

    @Autowired
    private TemplateEngine templateEngine;

    public SimpleMailMessage constructResetTokenEmail(
            String contextPath, Locale locale, String token, User user, String password
    ) {

        String url = contextPath + "/newUser?token=" + token;
        String message = "\nPlease click on this link to verify your email and edit your personal information.";
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getMail());
        email.setSubject("Confirmation email");
        email.setText(url + message);
        email.setFrom(env.getProperty("support.email"));
        return email;

    }
}