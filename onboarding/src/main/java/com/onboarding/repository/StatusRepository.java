package com.onboarding.repository;

import com.onboarding.entity.Status;
import com.onboarding.entity.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    List<Status> findAll();
    Status save(Subdivision subdivision);
}
