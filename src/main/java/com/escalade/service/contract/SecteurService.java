package com.escalade.service.contract;

import com.escalade.model.Secteur;

import java.util.List;

public interface SecteurService
{
    List<Secteur> getSectorByIdSite(Long id);
    Secteur getSectorById(Long id);
    void insertSecteur(Secteur newSecteur, Long idSite);
    void deleteSecteurById (Long idSecteur);
}
