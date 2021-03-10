package com.example.quizrest.MapperImpl;

import DTO.PlayerDTO;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import Entities.Player;
import com.example.quizrest.Mapper.CountryMapper;
import com.example.quizrest.Mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-06T20:25:59+0100",
    comments = "version: 1.4.0.Beta3, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)


public class PlayerMapperImpl implements PlayerMapper {



    private CountryMapper countryMapper=new CountryMapperImpl();

    @Override
    public PlayerDTO toDTO(Player entity) {
        if ( entity == null ) {
            return null;
        }

        PlayerDTO playerDTO = new PlayerDTO();

        playerDTO.setId( entity.getId() );
        playerDTO.setName( entity.getName() );
        playerDTO.setMail( entity.getMail() );
        playerDTO.setCountry( countryMapper.toDTO( entity.getCountry() ) );
        //playerDTO.setPlayer_games( playerGameMapper.toDTOList( entity.getPlayer_games() ) );

        return playerDTO;
    }

    @Override
    public Player toEntities(PlayerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Player player = new Player();

        player.setId( dto.getId() );
        player.setName( dto.getName() );
        player.setMail( dto.getMail() );
        player.setCountry( countryMapper.toEntities( dto.getCountry() ) );
        //player.setPlayer_games( playerGameMapper.toEntitiesList( dto.getPlayer_games() ) );

        return player;
    }

    @Override
    public List<PlayerDTO> toDTOList(List<Player> entitiesList) {
        if ( entitiesList == null ) {
            return null;
        }

        List<PlayerDTO> list = new ArrayList<PlayerDTO>( entitiesList.size() );
        for ( Player player : entitiesList ) {
            list.add( toDTO( player ) );
        }

        return list;
    }

    @Override
    public List<Player> toEntitiesList(List<PlayerDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Player> list = new ArrayList<Player>( dtoList.size() );
        for ( PlayerDTO playerDTO : dtoList ) {
            list.add( toEntities( playerDTO ) );
        }

        return list;
    }
}
