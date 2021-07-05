package com.example.quizrest.ServiceImpl;

import DAO.QuestionDAOI;
import DAO.QuestionDAOI;
import DAOImpl.QuestionDAOImpl;
import DTO.QuestionDTO;
import DTO.CategoryDTO;
import DTO.DifficultyDTO;
import DTO.QuestionDTO;

import Entities.Question;
import Services.QuestionServices;
import com.example.quizrest.Mapper.QuestionMapper;
import com.example.quizrest.Mapper.QuestionMapper;
import com.example.quizrest.MapperImpl.QuestionMapperImpl;
import com.example.quizrest.MapperImpl.QuestionMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

@Service
@Component
public class QuestionServicesImpl implements QuestionServices {

    QuestionMapper questionMapper=new QuestionMapperImpl();

    @Autowired
    QuestionDAOI questionDAOI;

    @Override
    public QuestionDTO save(QuestionDTO entityDTO) {
        Question question = questionDAOI.findByName(entityDTO.getName());
        if(question!=null){
            return questionMapper.toDTO(null);
        }
        return questionMapper.toDTO(questionDAOI.save(questionMapper.toEntities(entityDTO)));
    }

    @Override
    public QuestionDTO update(QuestionDTO entityDTO) {
        QuestionDTO QuestionDTO=findById(entityDTO.getId());

        QuestionDTO.setName(entityDTO.getName());
        questionDAOI.save(questionMapper.toEntities(QuestionDTO));
        return findById(entityDTO.getId());
    }

    @Override
    public void delete(Long id) {
        questionDAOI.deleteById(id);
    }

    @Override
    public QuestionDTO findById(Long id) {
        return questionMapper.toDTO(questionDAOI.getOne(id));
    }

    @Override
    public QuestionDTO findByName(String name) {
        return questionMapper.toDTO(questionDAOI.findByName(name));
    }

    @Override
    public List<QuestionDTO> findAll() {
        return questionMapper.toDTOList(questionDAOI.findAll());
    }

    @Override
    public List<QuestionDTO> findAllByName(String name) {
        return questionMapper.toDTOList(questionDAOI.findByNameLike(name));
    }

    @Override
    public List<QuestionDTO> findAllByCategoryId(Long id) {
        return questionMapper.toDTOList(questionDAOI.findAllByCategoryId(id));
    }

    @Override
    public List<QuestionDTO> findAllByDifficultyId(Long id) {
        return questionMapper.toDTOList(questionDAOI.findAllByDifficultyId(id));
    }

    @Override
    public List<QuestionDTO> findQuestionsByCategoryAndDifficulty(Long idDifficulty, Long idCategory) {
        return questionMapper.toDTOList(
                questionDAOI.findQuestionsByCategoryAndDifficulty(idDifficulty, idCategory));
    }
}
