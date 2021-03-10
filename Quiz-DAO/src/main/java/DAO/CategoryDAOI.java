package DAO;


import Entities.Answer;
import Entities.Category;
import Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDAOI extends JpaRepository<Category,Long> {

    List<Category> findByNameLike(String name);
    Category findByName(String name);

}