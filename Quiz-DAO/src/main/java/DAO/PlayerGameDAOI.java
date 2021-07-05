package DAO;



import Entities.PlayerGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface PlayerGameDAOI extends JpaRepository<PlayerGame,Long> {

    @Query("select q from PlayerGame q where q.player.id = ?1 ")
    public List<PlayerGame> findAllByPlayerId(Long id);



}
