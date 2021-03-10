package com.example.quizrest.ServiceImpl;

import DAO.PlayerDAOI;
import DTO.PlayerDTO;
import Services.PlayerServices;
import com.example.quizrest.Mapper.PlayerMapper;
import com.example.quizrest.MapperImpl.PlayerMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class PlayerServicesImpl implements PlayerServices {


    PlayerMapper playerMapper=new PlayerMapperImpl();
    
    @Autowired
    PlayerDAOI playerDAOI;

    @Override
    public List<PlayerDTO> sortPlayerByCountry(Long id) {
        return playerMapper.toDTOList(playerDAOI.findByCountryId(id));
    }
    @Override
    public PlayerDTO findByMail(String mail) {
        return playerMapper.toDTO(playerDAOI.findByMail(mail));
    }

    @Override
    public PlayerDTO save(PlayerDTO entityDTO) {
        return playerMapper.toDTO(playerDAOI.save(playerMapper.toEntities(entityDTO)));
    }

    @Override
    public PlayerDTO update(PlayerDTO entityDTO) {
        PlayerDTO playerDTO=findById(entityDTO.getId());
        playerDTO.setId(entityDTO.getId());
        playerDTO.setName(entityDTO.getName());
        return playerMapper.toDTO(playerDAOI.save(playerMapper.toEntities(playerDTO)));
    }

    @Override
    public void delete(Long id) {
        playerDAOI.deleteById(id);
    }

    @Override
    public PlayerDTO findById(Long id) {
        return playerMapper.toDTO(playerDAOI.getOne(id));
    }

    @Override
    public PlayerDTO findByName(String name) {
        return playerMapper.toDTO(playerDAOI.findByName(name));
    }

    @Override
    public List<PlayerDTO> findAll() {
        return playerMapper.toDTOList(playerDAOI.findAll());
    }

    @Override
    public List<PlayerDTO> findAllByName(String name) {
        return playerMapper.toDTOList(playerDAOI.findByNameLike(name));
    }
}
