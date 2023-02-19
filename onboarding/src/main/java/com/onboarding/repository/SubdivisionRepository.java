package com.onboarding.repository;

import com.onboarding.entity.Subdivision;
import com.onboarding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {
    Subdivision save(Subdivision subdivision);
//    List<Subdivision> find
}
