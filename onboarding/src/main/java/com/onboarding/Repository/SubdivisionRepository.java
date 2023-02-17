package com.onboarding.Repository;

import com.onboarding.Entity.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {
//    List<Subdivision> find
}
