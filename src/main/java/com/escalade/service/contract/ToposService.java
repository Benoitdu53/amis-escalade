package com.escalade.service.contract;

import com.escalade.model.Topos;

import java.util.List;

public interface ToposService {

    List<Topos> getToposByUtilisateur(String pseudo);
    void insertToposByUtilisateur(String pseudo, Topos topos);

}
