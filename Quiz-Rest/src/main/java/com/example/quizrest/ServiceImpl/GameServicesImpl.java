package com.example.quizrest.ServiceImpl;


import DAO.GameDAOI;
import DTO.GameDTO;
import Services.GameServices;
import com.example.quizrest.Mapper.GameMapper;
import com.example.quizrest.MapperImpl.GameMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
@Component
public class GameServicesImpl implements GameServices {


    GameMapper gameMapper=new GameMapperImpl();

    @Autowired
    GameDAOI gameDAOI;


    @Override
    public GameDTO save(GameDTO entityDTO) {
        return gameMapper.toDTO(gameDAOI.save(gameMapper.toEntities(entityDTO)));
    }

    @Override
    public GameDTO update(GameDTO entityDTO) {
        GameDTO gameDTO=findById(entityDTO.getId());
        gameDTO.setId(entityDTO.getId());
        gameDTO.setDate(entityDTO.getDate());
        return gameMapper.toDTO(gameDAOI.save(gameMapper.toEntities(gameDTO)));
    }

    @Override
    public void delete(Long id) {
        gameDAOI.deleteById(id);
    }

    @Override
    public GameDTO findById(Long id) {
        return gameMapper.toDTO(gameDAOI.getOne(id));
    }


    @Override
    public List<GameDTO> findAll() {
        return gameMapper.toDTOList(gameDAOI.findAll());
    }

    @Override
    public List<GameDTO> findByDateBetween(Date dateStart, Date dateEnd) {
        return gameMapper.toDTOList(gameDAOI.findByDateBetween(dateStart,dateEnd));
    }

    @Override
    public List<GameDTO> findAllByDifficultyId(Long id) {
        return gameMapper.toDTOList(gameDAOI.findAllByDifficultyId(id));
    }

    @Override
    public List<GameDTO> findAllByCategoryId(Long id) {
        return gameMapper.toDTOList(gameDAOI.findAllByCategoryId(id));
    }

    @Override
    public List<GameDTO> findGamesByCategoryAndDifficulty(Long idDifficulty, Long idCategory) {
        return gameMapper.toDTOList(gameDAOI.findGamesByCategoryAndDifficulty(idDifficulty,idCategory));
    }


}
