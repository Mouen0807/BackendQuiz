package com.example.quizrest.MapperImpl;

import DTO.QuestionDTO;

import java.util.ArrayList;
import java.util.List;

import Entities.Question;
import com.example.quizrest.Mapper.CategoryMapper;
import com.example.quizrest.Mapper.DifficultyMapper;
import com.example.quizrest.Mapper.QuestionMapper;

/*@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-06T20:25:58+0100",
    comments = "version: 1.4.0.Beta3, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)*/

public class QuestionMapperImpl implements QuestionMapper {


    private DifficultyMapper difficultyMapper=new DifficultyMapperImpl();

    private CategoryMapper categoryMapper=new CategoryMapperImpl();


    @Override
    public QuestionDTO toDTO(Question entity) {
        if ( entity == null ) {
            return null;
        }

        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setId( entity.getId() );
        questionDTO.setName( entity.getName() );
        questionDTO.setDifficulty( difficultyMapper.toDTO( entity.getDifficulty() ) );
        questionDTO.setCategory( categoryMapper.toDTO( entity.getCategory() ) );
        questionDTO.setConcatenedAnswers(entity.getConcatenedAnswers());
        questionDTO.setNumberOfCorrectAnswer(entity.getNumberOfCorrectAnswer());

        return questionDTO;
    }

    @Override
    public Question toEntities(QuestionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Question question = new Question();

        question.setId( dto.getId() );
        question.setName( dto.getName() );
        question.setDifficulty( difficultyMapper.toEntities( dto.getDifficulty() ) );
        question.setCategory( categoryMapper.toEntities( dto.getCategory() ) );
        question.setConcatenedAnswers(dto.getConcatenedAnswers());
        question.setNumberOfCorrectAnswer(dto.getNumberOfCorrectAnswer());

        return question;
    }

    @Override
    public List<QuestionDTO> toDTOList(List<Question> entitiesList) {
        if ( entitiesList == null ) {
            return null;
        }

        List<QuestionDTO> list = new ArrayList<QuestionDTO>( entitiesList.size() );
        for ( Question question : entitiesList ) {
            list.add( toDTO( question ) );
        }

        return list;
    }

    @Override
    public List<Question> toEntitiesList(List<QuestionDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Question> list = new ArrayList<Question>( dtoList.size() );
        for ( QuestionDTO questionDTO : dtoList ) {
            list.add( toEntities( questionDTO ) );
        }

        return list;
    }
}
