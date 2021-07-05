package com.example.quizrest.ServiceImpl;

import DAO.DifficultyDAOI;
import DTO.DifficultyDTO;
import Entities.Difficulty;
import Services.DifficultyServices;
import com.example.quizrest.Mapper.DifficultyMapper;
import com.example.quizrest.MapperImpl.DifficultyMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class DifficultyServicesImpl implements DifficultyServices {


    DifficultyMapper difficultyMapper=new DifficultyMapperImpl();

    @Autowired
    DifficultyDAOI difficultyDAOI;

    @Override
    public DifficultyDTO save(DifficultyDTO entityDTO) {
        Difficulty difficulty = difficultyDAOI.findByName(entityDTO.getName());
        if(difficulty!=null){
            return difficultyMapper.toDTO(null);
        }
        return difficultyMapper.toDTO(difficultyDAOI.save(difficultyMapper.toEntities(entityDTO)));
    }

    @Override
    public DifficultyDTO update(DifficultyDTO entityDTO) {
        DifficultyDTO DifficultyDTO=findById(entityDTO.getId());
        DifficultyDTO.setId(entityDTO.getId());
        DifficultyDTO.setName(entityDTO.getName());
        difficultyDAOI.save(difficultyMapper.toEntities(DifficultyDTO));
        return findById(entityDTO.getId());
    }

    @Override
    public void delete(Long id) {
        difficultyDAOI.deleteById(id);
    }

    @Override
    public DifficultyDTO findById(Long id) {
        return difficultyMapper.toDTO(difficultyDAOI.getOne(id));
    }

    @Override
    public DifficultyDTO findByName(String name) {
        return difficultyMapper.toDTO(difficultyDAOI.findByName(name));
    }

    @Override
    public List<DifficultyDTO> findAll() {
        return difficultyMapper.toDTOList(difficultyDAOI.findAll());
    }

    @Override
    public List<DifficultyDTO> findAllByName(String name) {
        return difficultyMapper.toDTOList(difficultyDAOI.findByNameLike(name));
    }


}
