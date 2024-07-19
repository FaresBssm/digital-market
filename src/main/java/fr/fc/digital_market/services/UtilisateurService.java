package fr.fc.digital_market.services;

import fr.fc.digital_market.entity.Utilisateur;
import fr.fc.digital_market.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    public Utilisateur saveUtilisateur(Utilisateur utilisateur) { return utilisateurRepository.save(utilisateur); }

    public void DeleteUtilisateurById(Long id) {utilisateurRepository.deleteById(id);}

    public List<Utilisateur> getAllUtilisateur(){return utilisateurRepository.findAll();}

    public Optional<Utilisateur> getUtilisateurById(Long id) {return utilisateurRepository.findById(id);}
}
