package com.escalade.dao;

import com.escalade.model.SiteEscalade;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ISiteDao extends JpaRepository<SiteEscalade, Long> { }
