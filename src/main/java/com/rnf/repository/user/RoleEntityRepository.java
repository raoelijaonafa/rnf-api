package com.rnf.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rnf.entity.user.RoleEntity;
import com.rnf.misc.EnumRole;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer> {
	Optional<RoleEntity> findRoleByName(EnumRole name);
}
