package boris.userservice;

import boris.userservice.entity.Role;
import boris.userservice.entity.User;
import boris.userservice.entity.UserRole;
import boris.userservice.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.HashSet;
import java.util.Set;

@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
public class UserServiceApplication implements CommandLineRunner{

    @Autowired
    private IUserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {

        User user1 = new User();
        user1.setUsername("boris");
        user1.setMail("boris.damyanov@gmail.com");
        user1.setPassword("password");
        user1.setFirstName("Borislav");
        user1.setLastName("Damyanov");

        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(1);
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1);
    }


    }

