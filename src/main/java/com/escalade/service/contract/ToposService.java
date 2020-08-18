package com.escalade.service.contract;

import com.escalade.model.Topos;
import com.escalade.model.Utilisateur;

import java.util.List;

public interface ToposService {

    List<Topos> getToposByPseudo(String pseudo);
    void insertToposByUtilisateur(Topos topos, String pseudo);
    List<Topos> getToposDispos(String pseudo);
}
