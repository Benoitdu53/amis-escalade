package com.escalade.service.contract;

import com.escalade.model.Longueur;
import com.escalade.model.Utilisateur;

import java.util.List;

public interface LongueurService
{
    void insertLongueur(Longueur newLongueur, Long idVoie, Utilisateur utilisateur);
    List<Longueur> getLongueurByVoieId(Long idVoie);
    void deleteById(Long idLongueur);
    List<Longueur> getLongueursByIdVoie(Long idVoie);
}
