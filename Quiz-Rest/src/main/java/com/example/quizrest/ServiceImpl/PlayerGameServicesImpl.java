package com.example.quizrest.ServiceImpl;

import DAO.PlayerGameDAOI;

import DTO.PlayerGameDTO;



import Services.PlayerGameServices;
import com.example.quizrest.Mapper.PlayerGameMapper;
import com.example.quizrest.MapperImpl.PlayerGameMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class PlayerGameServicesImpl implements PlayerGameServices {


        PlayerGameMapper playerGameMapper=new PlayerGameMapperImpl();

        @Autowired
        PlayerGameDAOI playerGameDAOI;


        @Override
        public PlayerGameDTO save(PlayerGameDTO entityDTO) {
            return playerGameMapper.toDTO(playerGameDAOI.save(playerGameMapper.toEntities(entityDTO)));
        }

        @Override
        public PlayerGameDTO update(PlayerGameDTO entityDTO) {
            PlayerGameDTO playerGameDTO=findById(entityDTO.getId());
            playerGameDTO.setId(entityDTO.getId());
            playerGameDTO.setGame(entityDTO.getGame());
            playerGameDTO.setPlayer(entityDTO.getPlayer());
            return playerGameMapper.toDTO(playerGameDAOI.save(playerGameMapper.toEntities(playerGameDTO)));
        }

        @Override
        public void delete(Long id) {
              playerGameDAOI.deleteById(id);
        }

        @Override
        public PlayerGameDTO findById(Long id) {
            return playerGameMapper.toDTO(playerGameDAOI.getOne(id));
        }


        @Override
        public List<PlayerGameDTO> findAll() {
             return playerGameMapper.toDTOList(playerGameDAOI.findAll());
        }

        @Override
        public List<PlayerGameDTO> findAllByPlayerId(Long id) {
            return playerGameMapper.toDTOList(playerGameDAOI.findAllByPlayerId(id));
        }
}
