package DAO;



import Entities.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface DifficultyDAOI extends JpaRepository<Difficulty,Long> {


    List<Difficulty> findByNameLike(String name);
    Difficulty findByName(String name);
}
