package DAO;

import Entities.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageModelDAOI extends JpaRepository<ImageModel, Long>
{
        List<ImageModel> findByName(String name);

}

