package com.rnf.repository.referentiel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rnf.entity.referentiel.LoiFinanceEntity;

@Repository
public interface LoidFinanceEntityRepository extends JpaRepository<LoiFinanceEntity, Integer> { 
}
