package com.onboarding.repository;

import com.onboarding.entity.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {
//    List<Subdivision> find
}
