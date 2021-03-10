package DAO;



import Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface QuestionDAOI extends JpaRepository<Question,Long> {

    List<Question> findByNameLike(String name);

    Question findByName(String name);

    @Query("select q from Question q where q.difficulty.id = ?1 ")
    public List<Question> findAllByDifficultyId(Long id);

    @Query("select q from Question q where q.category.id = ?1 ")
    public List<Question> findAllByCategoryId(Long id);

    @Query("select q from Question q where q.difficulty.id = ?1 and q.category.id = ?2")
    List<Question> findQuestionsByCategoryAndDifficulty(Long idDifficulty, Long idCategory);
}
