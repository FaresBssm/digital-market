package fr.fc.digital_market.entity;

import fr.fc.digital_market.enumerations.AbonnementType;
import fr.fc.digital_market.enumerations.UtilisateurStatus;
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
    private AbonnementType abonnementType;
    @Enumerated(EnumType.STRING)
    private UtilisateurStatus status;

}
