package Services;



import DTO.QuestionDTO;
import Entities.Question;

import java.util.List;

public interface QuestionServices extends DefaultServices<QuestionDTO,Long> {


    public List<QuestionDTO> findAllByCategoryId(Long id);
    public List<QuestionDTO> findAllByDifficultyId(Long id);
    List<QuestionDTO> findQuestionsByCategoryAndDifficulty(Long idDifficulty, Long idCategory);
    public List<QuestionDTO> findAllByName(String name);


}
