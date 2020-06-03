package com.escalade.dao;

import com.escalade.model.Secteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorDao extends CrudRepository<Secteur, Long> {

}
