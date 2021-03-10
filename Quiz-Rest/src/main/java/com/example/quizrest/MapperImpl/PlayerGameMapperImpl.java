package com.example.quizrest.MapperImpl;

import DTO.PlayerGameDTO;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import Entities.PlayerGame;
import com.example.quizrest.Mapper.GameMapper;
import com.example.quizrest.Mapper.PlayerGameMapper;
import com.example.quizrest.Mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-06T20:25:58+0100",
    comments = "version: 1.4.0.Beta3, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)


public class PlayerGameMapperImpl implements PlayerGameMapper {


    private PlayerMapper playerMapper=new PlayerMapperImpl();
    private GameMapper gameMapper=new GameMapperImpl();

    @Override
    public PlayerGameDTO toDTO(PlayerGame entity) {
        if ( entity == null ) {
            return null;
        }

        PlayerGameDTO playerGameDTO = new PlayerGameDTO();

        playerGameDTO.setId(entity.getId());
        playerGameDTO.setPlayer( playerMapper.toDTO( entity.getPlayer() ) );
        playerGameDTO.setGame( gameMapper.toDTO( entity.getGame() ) );
        playerGameDTO.setScore( entity.getScore() );
        playerGameDTO.setSecondEffective( entity.getSecondEffective() );

        return playerGameDTO;
    }

    @Override
    public PlayerGame toEntities(PlayerGameDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PlayerGame playerGame = new PlayerGame();
        playerGame.setId(dto.getId());
        playerGame.setPlayer( playerMapper.toEntities( dto.getPlayer() ) );
        playerGame.setGame( gameMapper.toEntities( dto.getGame() ) );
        playerGame.setScore( dto.getScore() );
        playerGame.setSecondEffective( dto.getSecondEffective() );

        return playerGame;
    }

    @Override
    public List<PlayerGameDTO> toDTOList(List<PlayerGame> entitiesList) {
        if ( entitiesList == null ) {
            return null;
        }

        List<PlayerGameDTO> list = new ArrayList<PlayerGameDTO>( entitiesList.size() );
        for ( PlayerGame playerGame : entitiesList ) {
            list.add( toDTO( playerGame ) );
        }

        return list;
    }

    @Override
    public List<PlayerGame> toEntitiesList(List<PlayerGameDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<PlayerGame> list = new ArrayList<PlayerGame>( dtoList.size() );
        for ( PlayerGameDTO playerGameDTO : dtoList ) {
            list.add( toEntities( playerGameDTO ) );
        }

        return list;
    }
}
