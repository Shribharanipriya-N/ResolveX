package com.application.ResolveX.repository;

import com.application.ResolveX.entity.StarredEntity;
import com.application.ResolveX.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarredRepository extends JpaRepository<StarredEntity,Integer> {

    List<StarredEntity> findByUser(UserEntity user);;
}
