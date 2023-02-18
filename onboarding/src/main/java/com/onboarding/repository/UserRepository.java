package com.onboarding.repository;

import com.onboarding.entity.Status;
import com.onboarding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
    User findById(long userId);

   // List<User> findUsersByStatus(Status status);   //получить всех сотрудников HR-ов, например
}
