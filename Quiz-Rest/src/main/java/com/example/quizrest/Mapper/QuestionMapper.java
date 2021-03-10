package com.example.quizrest.Mapper;

import DTO.QuestionDTO;
import Entities.Question;

//import org.mapstruct.Mapper;




/*@Mapper(componentModel = "spring", uses = {DifficultyMapper.class,
        CategoryMapper.class,
        AnswerMapper.class})*/
public interface QuestionMapper extends DefaultMapper<QuestionDTO, Question> {

    //QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);
}
