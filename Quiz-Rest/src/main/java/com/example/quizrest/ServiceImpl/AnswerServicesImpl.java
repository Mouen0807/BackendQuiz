package com.example.quizrest.ServiceImpl;

import DAO.AnswerDAOI;
import DAO.AnswerDAOI;
import DAOImpl.AnswerDAOImpl;
import DTO.AnswerDTO;
import DTO.AnswerDTO;
import Entities.Answer;
import Services.AnswerServices;
import com.example.quizrest.Mapper.AnswerMapper;
import com.example.quizrest.Mapper.AnswerMapper;
import com.example.quizrest.MapperImpl.AnswerMapperImpl;
import com.example.quizrest.MapperImpl.AnswerMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class AnswerServicesImpl implements AnswerServices {

    AnswerMapper answerMapper=new AnswerMapperImpl();

    @Autowired
    AnswerDAOI answerDAOI;

    @Override
    public AnswerDTO save(AnswerDTO entityDTO) {
        return answerMapper.toDTO(answerDAOI.save(answerMapper.toEntities(entityDTO)));
    }

    @Override
    public AnswerDTO update(AnswerDTO entityDTO) {
        AnswerDTO AnswerDTO=findById(entityDTO.getId());

        AnswerDTO.setName(entityDTO.getName());
        answerDAOI.save(answerMapper.toEntities(AnswerDTO));
        return findById(entityDTO.getId());
    }

    @Override
    public void delete(Long id) {
        answerDAOI.deleteById(id);
    }

    @Override
    public AnswerDTO findById(Long id) {
        return answerMapper.toDTO(answerDAOI.getOne(id));
    }

    @Override
    public AnswerDTO findByName(String name) {
        return answerMapper.toDTO(answerDAOI.findByName(name));
    }

    @Override
    public List<AnswerDTO> findAll() {
        return answerMapper.toDTOList(answerDAOI.findAll());
    }

    @Override
    public List<AnswerDTO> findAllByName(String name) {
        return answerMapper.toDTOList(answerDAOI.findByNameLike(name));
    }

}
