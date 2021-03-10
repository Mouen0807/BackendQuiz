package Services;

import DTO.CategoryDTO;
import DTO.DifficultyDTO;
import DTO.PlayerDTO;
import DTO.PlayerGameDTO;
import Entities.PlayerGame;

import java.util.List;

public interface PlayerGameServices {

    public PlayerGameDTO save(PlayerGameDTO entity);
    public PlayerGameDTO update(PlayerGameDTO entity);
    public void delete(Long id);
    public PlayerGameDTO findById(Long id);
    public List<PlayerGameDTO> findAll();

    public List<PlayerGameDTO> findAllByPlayerId(Long id);

}
