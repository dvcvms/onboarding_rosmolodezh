package com.onboarding.repository;

import com.onboarding.entity.AnswerEntity;
import com.onboarding.entity.QuestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository  extends CrudRepository<QuestionEntity, Long> {
    /**
     * Репозиторий офферов для клиента
     */
    QuestionEntity findById(long id);

    QuestionEntity save(QuestionEntity question);
}
