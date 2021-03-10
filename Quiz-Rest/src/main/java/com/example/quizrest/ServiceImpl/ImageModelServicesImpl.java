package com.example.quizrest.ServiceImpl;


import DAO.ImageModelDAOI;
import Entities.ImageModel;
import Services.ImageModelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ImageModelServicesImpl implements ImageModelServices {

    @Autowired
    ImageModelDAOI imageModelDAOI;

    @Override
    public ImageModel save(ImageModel entity) {
        return imageModelDAOI.save(entity);
    }

    @Override
    public ImageModel update(ImageModel entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        imageModelDAOI.deleteById(id);
    }

    @Override
    public ImageModel findById(Long id) {
        return imageModelDAOI.findById(id).get();
    }

    @Override
    public ImageModel findByName(String name) {
        List<ImageModel> list = imageModelDAOI.findByName(name);
        if(list.size()!=0)
            return imageModelDAOI.findByName(name).get(0);
        else
            return null;
    }

    @Override
    public List<ImageModel> findAll() {
        return imageModelDAOI.findAll();
    }

    @Override
    public List<ImageModel> findAllByName(String name) {
        return imageModelDAOI.findByName(name);
    }
}
