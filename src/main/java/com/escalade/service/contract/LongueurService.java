package com.escalade.service.contract;

import com.escalade.model.Longueur;

import java.util.List;

public interface LongueurService
{
    void insertLongueur(Longueur newLongueur, Long idVoie);
    List<Longueur> getLongueurByVoieId(Long idVoie);
    void deleteById(Long idLongueur);
}
