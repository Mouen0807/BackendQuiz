package DAO;



import Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryDAOI extends JpaRepository<Country,Long> {

    List<Country> findByNameLike(String name);
    Country findByName(String name);

}
