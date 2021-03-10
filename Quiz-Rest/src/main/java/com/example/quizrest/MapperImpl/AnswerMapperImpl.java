package com.example.quizrest.MapperImpl;

import DTO.AnswerDTO;

import Entities.Answer;
import com.example.quizrest.Mapper.AnswerMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-06T20:25:59+0100",
    comments = "version: 1.4.0.Beta3, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public AnswerDTO toDTO(Answer entity) {
        if ( entity == null ) {
            return null;
        }

        AnswerDTO answerDTO = new AnswerDTO();

        answerDTO.setId( entity.getId() );
        answerDTO.setName( entity.getName() );
        answerDTO.setGood( entity.isGood() );

        return answerDTO;
    }

    @Override
    public Answer toEntities(AnswerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setId( dto.getId() );
        answer.setName( dto.getName() );
        answer.setGood( dto.isGood() );

        return answer;
    }

    @Override
    public List<AnswerDTO> toDTOList(List<Answer> entitiesList) {
        if ( entitiesList == null ) {
            return null;
        }

        List<AnswerDTO> list = new ArrayList<AnswerDTO>( entitiesList.size() );
        for ( Answer answer : entitiesList ) {
            list.add( toDTO( answer ) );
        }

        return list;
    }

    @Override
    public List<Answer> toEntitiesList(List<AnswerDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Answer> list = new ArrayList<Answer>( dtoList.size() );
        for ( AnswerDTO answerDTO : dtoList ) {
            list.add( toEntities( answerDTO ) );
        }

        return list;
    }
}
