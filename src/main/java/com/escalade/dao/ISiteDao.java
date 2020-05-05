package com.escalade.dao;

import com.escalade.model.SiteEscalade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiteDao extends JpaRepository<SiteEscalade, Long> { }
