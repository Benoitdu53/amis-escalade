package com.escalade.service.contract;

import com.escalade.model.Voie;

import java.util.List;

public interface VoieService
{
    List<Voie> getVoieByidSite(Long id);
    void insertVoie(Voie newVoie, Long idSecteur);
}
