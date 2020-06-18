package com.escalade.service.contract;

import com.escalade.model.Voie;

import java.util.List;

public interface VoieService
{
    List<Voie> getVoieBySecteurId(Long idSecteur);
    void insertVoie(Voie newVoie, Long idSecteur, Long idSite);
}
