package com.example.quizrest.MapperImpl;

import DTO.GameDTO;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import Entities.Game;
import com.example.quizrest.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-06T20:25:59+0100",
    comments = "version: 1.4.0.Beta3, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)

public class GameMapperImpl implements GameMapper {


    private DifficultyMapper difficultyMapper=new DifficultyMapperImpl();
    private CategoryMapper categoryMapper=new CategoryMapperImpl();
    private QuestionMapper questionMapper=new QuestionMapperImpl();


    @Override
    public GameDTO toDTO(Game entity) {
        if ( entity == null ) {
            return null;
        }

        GameDTO gameDTO = new GameDTO();

        gameDTO.setId( entity.getId() );
        gameDTO.setDate( entity.getDate() );
        gameDTO.setDifficulty( difficultyMapper.toDTO( entity.getDifficulty() ) );
        gameDTO.setCategory( categoryMapper.toDTO( entity.getCategory() ) );
        gameDTO.setQuestions( questionMapper.toDTOList( entity.getQuestions() ) );
        //gameDTO.setPlayer_games( playerGameMapper.toDTOList( entity.getPlayer_games() ) );

        return gameDTO;
    }

    @Override
    public Game toEntities(GameDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Game game = new Game();

        game.setId( dto.getId() );
        game.setDate( dto.getDate() );
        game.setDifficulty( difficultyMapper.toEntities( dto.getDifficulty() ) );
        game.setCategory( categoryMapper.toEntities( dto.getCategory() ) );
        game.setQuestions( questionMapper.toEntitiesList( dto.getQuestions() ) );
        //game.setPlayer_games( playerGameMapper.toEntitiesList( dto.getPlayer_games() ) );

        return game;
    }

    @Override
    public List<GameDTO> toDTOList(List<Game> entitiesList) {
        if ( entitiesList == null ) {
            return null;
        }

        List<GameDTO> list = new ArrayList<GameDTO>( entitiesList.size() );
        for ( Game game : entitiesList ) {
            list.add( toDTO( game ) );
        }

        return list;
    }

    @Override
    public List<Game> toEntitiesList(List<GameDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Game> list = new ArrayList<Game>( dtoList.size() );
        for ( GameDTO gameDTO : dtoList ) {
            list.add( toEntities( gameDTO ) );
        }

        return list;
    }
}
