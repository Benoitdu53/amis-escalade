package com.escalade.service.impl;

import com.escalade.dao.LongueurDao;
import com.escalade.dao.UtilisateurDao;
import com.escalade.model.Longueur;
import com.escalade.model.Utilisateur;
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

    @Autowired
    private UtilisateurDao utilisateurDao;




    /**
     *          Ajouter une longueur
     * @param newLongueur
     * @param idVoie
     */
    @Override
    public void insertLongueur( Longueur newLongueur, Long idVoie, String pseudo)
    {
            Voie voie = voieService.getVoieById(idVoie);
            Utilisateur utilisateur = utilisateurDao.getUtilisateurByPseudo(pseudo);

            newLongueur.setUtilisateur(utilisateur);
            newLongueur.setVoie(voie);
            longueurDao.save(newLongueur);

    }




    /**
     *          Récupère les longeurs de la voie par son idVoie
     * @param idVoie
     * @return
     */
    @Override
    public List<Longueur> getLongueurByVoieId(final Long idVoie)
    {
        return longueurDao.getLongueurByVoieId(voieService.getVoieById(idVoie));
    }




    /**
     *          Supprime la longueur
     * @param idLongueur
     */
    @Override
    public void deleteById(final Long idLongueur)
    {
        longueurDao.deleteById(idLongueur);
    }




    /**
     *      Récupère les longueurs par son idSecteur
     * @param idVoie
     * @return
     */
    @Override
    public List<Longueur> getLongueursByIdVoie(final Long idVoie)
    {
        return longueurDao.getLongueursByIdVoie(idVoie);
    }
}
