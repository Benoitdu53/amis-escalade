package com.escalade.dao;

import com.escalade.model.Longueur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LongueurDao extends CrudRepository<Longueur, Long>
{

}
