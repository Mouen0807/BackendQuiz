package DAO;


import Entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerDAOI extends JpaRepository<Answer,Long> {

    List<Answer> findByNameLike(String name);
    Answer findByName(String name);

}
