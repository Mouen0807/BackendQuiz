package Services;

import DTO.GameDTO;
import Entities.Game;


import java.util.Date;
import java.util.List;


public interface GameServices  {

    public GameDTO save(GameDTO entity);
    public GameDTO update(GameDTO entity);
    public void delete(Long id);
    public GameDTO findById(Long id);
    public List<GameDTO> findAll();
    List<GameDTO> findByDateBetween(Date dateStart, Date dateEnd);
    public List<GameDTO> findAllByDifficultyId(Long id);
    public List<GameDTO> findAllByCategoryId(Long id);
    List<GameDTO> findGamesByCategoryAndDifficulty(Long idDifficulty, Long idCategory);
    
}
