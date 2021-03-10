package DAO;


import Entities.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Date;
import java.util.List;


public interface GameDAOI extends JpaRepository<Game,Long> {



    List<Game> findByDateBetween(Date dateStart, Date dateEnd);

    @Query("select q from Game q where q.difficulty.id = ?1 ")
    public List<Game> findAllByDifficultyId(Long id);

    @Query("select q from Game q where q.category.id = ?1 ")
    public List<Game> findAllByCategoryId(Long id);

    @Query("select q from Game q where q.difficulty.id = ?1 and q.category.id = ?2")
    List<Game> findGamesByCategoryAndDifficulty(Long idDifficulty, Long idCategory);

}
