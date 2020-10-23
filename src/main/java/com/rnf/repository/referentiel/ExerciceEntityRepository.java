package com.rnf.repository.referentiel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rnf.entity.referentiel.ExerciceEntity;

@Repository
public interface ExerciceEntityRepository extends JpaRepository<ExerciceEntity, Integer> {
	Optional<ExerciceEntity> findByExercice(Integer exercice);
}
