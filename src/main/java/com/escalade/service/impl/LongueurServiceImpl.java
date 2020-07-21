package com.escalade.service.impl;

import com.escalade.dao.LongueurDao;
import com.escalade.model.Longueur;
import com.escalade.model.Voie;
import com.escalade.service.contract.LongueurService;
import com.escalade.service.contract.VoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LongueurServiceImpl implements LongueurService
{
    @Autowired
    private VoieService voieService;

    private final LongueurDao longueurDao;
    @Autowired
    public LongueurServiceImpl(LongueurDao longueurDao){this.longueurDao = longueurDao;}

    @Override
    public void insertLongueur( Longueur newLongueur, Long idVoie)
    {
        String cotation = newLongueur.getCotation();

        if (!cotation.substring(0).matches("a") || !cotation.substring(1).matches("1")){
            // TODO Ajoute un message "Veuillez saisir un chiffre ( minimum 3 maximum 8 ) et une lettre (a, b, ou c ) ex : 5a"
        }else
        {
            Voie voie = voieService.getVoieById(idVoie);
            newLongueur.setVoie(voie);
            longueurDao.save(newLongueur);
        }
    }

    @Override
    public List<Longueur> getLongueurByVoieId(final Long idVoie)
    {
        return longueurDao.getLongueurByVoieId(voieService.getVoieById(idVoie));
    }

    @Override
    public void deleteById(final Long idLongueur)
    {
        longueurDao.deleteById(idLongueur);
    }
}