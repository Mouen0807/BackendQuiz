package com.example.quizrest.Mapper;

import DTO.GameDTO;
import Entities.Game;

//import org.mapstruct.Mapper;



/*@Mapper(componentModel = "spring", uses = {
        DifficultyMapper.class,
        CategoryMapper.class,
        QuestionMapper.class,
        PlayerGameMapper.class})*/
public interface GameMapper extends DefaultMapper<GameDTO, Game>{

    //GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);
}
