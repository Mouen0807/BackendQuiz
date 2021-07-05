package Services;

import DTO.CountryDTO;
import DTO.PlayerDTO;
import Entities.Player;

import java.util.List;

public interface PlayerServices extends DefaultServices<PlayerDTO,Long>{

    List<PlayerDTO> sortPlayerByCountry(Long id);
    PlayerDTO findByMail(String mail);
    PlayerDTO findByNameAndPassword(String name,String password);


}
