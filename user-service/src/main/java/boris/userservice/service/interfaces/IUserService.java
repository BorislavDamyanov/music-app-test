package boris.userservice.service.interfaces;

import boris.userservice.entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface IUserService {

    User createUser(User user);
    User getUser(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
}
