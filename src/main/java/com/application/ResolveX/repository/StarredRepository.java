package com.application.ResolveX.repository;

import com.application.ResolveX.entity.StarredEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarredRepository extends JpaRepository<StarredEntity,Integer> {
}
