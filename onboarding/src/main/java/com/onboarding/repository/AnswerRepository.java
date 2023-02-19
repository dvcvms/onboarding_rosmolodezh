package com.onboarding.repository;

import com.onboarding.entity.AnswerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AnswerRepository extends CrudRepository<AnswerEntity, Long> {
    /**
     * Репозиторий офферов для клиента
     */

    AnswerEntity save(AnswerEntity answer);
    }

