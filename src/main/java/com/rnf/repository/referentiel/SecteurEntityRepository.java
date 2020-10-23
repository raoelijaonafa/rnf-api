package com.rnf.repository.referentiel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rnf.entity.referentiel.SecteurEntity;

@Repository
public interface SecteurEntityRepository extends JpaRepository<SecteurEntity, Integer> { 
}
