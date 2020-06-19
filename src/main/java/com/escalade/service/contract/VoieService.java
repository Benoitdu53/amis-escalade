package com.escalade.service.contract;

import com.escalade.model.Voie;

import java.util.List;

public interface VoieService
{
    List<Voie> getVoieBySecteurId(Long idSecteur);
    Voie getVoieById(Long idVoie);
    void insertVoie(Voie newVoie, Long idSecteur);
    void deleteVoieById(Long idVoie);
}
