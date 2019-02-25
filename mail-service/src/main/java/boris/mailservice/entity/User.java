package boris.mailservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {



    private Long id;
    private String username;

    private String firstName;

    private String lastName;

    private String mail;




}
