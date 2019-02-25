package boris.userservice.controller;


import boris.userservice.entity.User;
import boris.userservice.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "confirmation_mail_json";

    @GetMapping("/publish/{mail}")
    public String post(@PathVariable("mail") final String mail) {

        kafkaTemplate.send(TOPIC, new User("bodamyanov", "boris.damyanov@gmail.com"));

        return "Published successfully";
    }

    @RequestMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }


    @GetMapping("/test")
    public String test(){
        return "Return this user string";
    }


    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable("id")Long id){
        return userService.getUser(id);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id")Long id){
        userService.deleteUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody User user){

        User savedUser = userService.createUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
