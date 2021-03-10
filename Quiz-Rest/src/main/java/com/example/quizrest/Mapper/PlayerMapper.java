package com.example.quizrest.Mapper;

import DTO.PlayerDTO;
import Entities.Player;

//import org.mapstruct.Mapper;




//@Mapper(componentModel = "spring", uses = {PlayerGameMapper.class,CountryMapper.class})
public interface PlayerMapper extends DefaultMapper<PlayerDTO, Player> {

  //  PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);
}
