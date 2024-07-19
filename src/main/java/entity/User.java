package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
