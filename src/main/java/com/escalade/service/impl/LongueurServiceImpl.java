package com.escalade.service.impl;

import com.escalade.dao.LongueurDao;
import com.escalade.service.contract.LongueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LongueurServiceImpl implements LongueurService
{

    private final LongueurDao longueurDao;
    @Autowired
    public LongueurServiceImpl(LongueurDao longueurDao){this.longueurDao = longueurDao;}

}
