package com.rnf.repository.referentiel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rnf.entity.referentiel.MinistereEntity;

@Repository
public interface MinistereEntityRepository extends JpaRepository<MinistereEntity, Integer> { 
}
