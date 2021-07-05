package DAO;


import Entities.Player;
import Entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PlayerDAOI extends JpaRepository<Player, Long> {

    List<Player> findByNameLike(String name);
    Player findByName(String name);
    Player findByMail(String mail);

    @Query("select q from Player q where q.country.id = ?1 ")
    List<Player> findByCountryId(Long id);

    Player findPlayerByNameAndPassword(String name,String Password);
    Player findPlayerByNameAndMail(String name,String mail);
}
