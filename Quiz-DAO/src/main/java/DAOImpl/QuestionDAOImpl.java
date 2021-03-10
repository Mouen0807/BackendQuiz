package DAOImpl;

import DAO.QuestionDAOI;
import Entities.Question;


import java.util.List;

public class QuestionDAOImpl {}/*extends DefaultDAOImpl<Question,Long> implements QuestionDAOI {

    public  QuestionDAOImpl(){

        super(Question.class);
    }

    public List<Question> findAllByDifficulty(Long id){
        logger.info("JPA Loading all Questions for com.example.quizEntities.Entities.Difficulty "+ id);
        return getEntityManager().createQuery("SELECT question FROM Question question" +
                " WHERE question.difficulty.id = :id", Question.class)
                .setParameter("id", id)
                .getResultList();
    }
}
*/