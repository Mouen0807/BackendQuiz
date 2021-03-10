package com.example.quizrest.Mapper;

import DTO.PlayerGameDTO;
import Entities.PlayerGame;

//import org.mapstruct.Mapper;



//@Mapper(componentModel = "spring", uses = {PlayerMapper.class, GameMapper.class})
public interface PlayerGameMapper extends DefaultMapper<PlayerGameDTO, PlayerGame>{

   // PlayerGameMapper INSTANCE = Mappers.getMapper(PlayerGameMapper.class);
}
