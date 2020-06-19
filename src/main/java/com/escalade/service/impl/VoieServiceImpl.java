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
    public List<Voie> getVoieBySecteurId(Long idSecteur)
    {
        return voieDao.getVoieBySecteurId(secteurService.getSectorById(idSecteur));
    }

    @Override
    public Voie getVoieById(final Long idVoie)
    {
        return voieDao.getVoieById(idVoie);
    }

    @Override
    public void insertVoie(Voie newVoie, Long idSecteur)
    {
        Secteur secteur = secteurService.getSectorById(idSecteur);
        newVoie.setSecteur(secteur);
        voieDao.save(newVoie);
    }

    @Override
    public void deleteVoieById(final Long idVoie)
    {
        voieDao.deleteById(idVoie);
    }

}
