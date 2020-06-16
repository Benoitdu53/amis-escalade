package com.escalade.service.impl;

import com.escalade.dao.VoieDao;
import com.escalade.model.Secteur;
import com.escalade.model.Voie;
import com.escalade.service.contract.SecteurService;
import com.escalade.service.contract.VoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoieServiceImpl implements VoieService
{
    @Autowired
    private SecteurService secteurService;

    private final VoieDao voieDao;
    @Autowired
    public VoieServiceImpl(VoieDao voieDao){
        this.voieDao = voieDao;
    }

    @Override
    public List<Voie> getVoieByidSite(Long id)
    {
        return voieDao.getVoieByidSite(id);
    }

    @Override
    public void insertVoie(final Voie newVoie, final Long idSecteur)
    {
        Secteur secteur = secteurService.getSectorById(idSecteur);
        newVoie.setSecteur(secteur);
        voieDao.save(newVoie);
    }

}
