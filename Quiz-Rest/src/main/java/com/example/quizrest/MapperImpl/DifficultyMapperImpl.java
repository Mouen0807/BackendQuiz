package com.example.quizrest.MapperImpl;

import DTO.DifficultyDTO;

import Entities.Difficulty;
import com.example.quizrest.Mapper.DifficultyMapper;
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
public class DifficultyMapperImpl implements DifficultyMapper {

    @Override
    public DifficultyDTO toDTO(Difficulty entity) {
        if ( entity == null ) {
            return null;
        }

        DifficultyDTO difficultyDTO = new DifficultyDTO();

        difficultyDTO.setId( entity.getId() );
        difficultyDTO.setName( entity.getName() );
        difficultyDTO.setSeconds( entity.getSeconds() );
        difficultyDTO.setNumberQuestions( entity.getNumberQuestions() );

        return difficultyDTO;
    }

    @Override
    public Difficulty toEntities(DifficultyDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Difficulty difficulty = new Difficulty();

        difficulty.setId( dto.getId() );
        difficulty.setName( dto.getName() );
        difficulty.setSeconds( dto.getSeconds() );
        difficulty.setNumberQuestions( dto.getNumberQuestions() );

        return difficulty;
    }

    @Override
    public List<DifficultyDTO> toDTOList(List<Difficulty> entitiesList) {
        if ( entitiesList == null ) {
            return null;
        }

        List<DifficultyDTO> list = new ArrayList<DifficultyDTO>( entitiesList.size() );
        for ( Difficulty difficulty : entitiesList ) {
            list.add( toDTO( difficulty ) );
        }

        return list;
    }

    @Override
    public List<Difficulty> toEntitiesList(List<DifficultyDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Difficulty> list = new ArrayList<Difficulty>( dtoList.size() );
        for ( DifficultyDTO difficultyDTO : dtoList ) {
            list.add( toEntities( difficultyDTO ) );
        }

        return list;
    }
}
