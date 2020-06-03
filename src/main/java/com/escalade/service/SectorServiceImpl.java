package com.escalade.service;

import com.escalade.dao.SectorDao;
import com.escalade.model.Secteur;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SectorServiceImpl implements SectorService{

    @Autowired
    private SectorDao sectorDao;

    @Override
    public List<Secteur> getAllSector()
    {
        return StreamSupport.stream(sectorDao.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
