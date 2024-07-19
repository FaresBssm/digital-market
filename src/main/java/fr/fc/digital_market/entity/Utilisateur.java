package fr.fc.digital_market.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UtilisateurStatus status;

}
