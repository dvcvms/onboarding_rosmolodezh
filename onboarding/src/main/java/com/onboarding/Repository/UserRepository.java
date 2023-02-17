package com.onboarding.Repository;

import com.onboarding.Entity.Status;
import com.onboarding.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
    User findUserByUserId(long userId);
    List<User> findUsersByStatus(Status status);   //получить всех сотрудников HR-ов, например
}
