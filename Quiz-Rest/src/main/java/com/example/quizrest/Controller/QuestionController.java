package com.example.quizrest.Controller;

import DTO.*;
import Entities.Difficulty;
import com.example.quizrest.ServiceImpl.AnswerServicesImpl;
import com.example.quizrest.ServiceImpl.CategoryServicesImpl;
import com.example.quizrest.ServiceImpl.DifficultyServicesImpl;
import com.example.quizrest.ServiceImpl.QuestionServicesImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(description="Api management Question")
@RestController

public class QuestionController {
    protected  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    QuestionServicesImpl questionServicesImpl;

    @Autowired
    CategoryServicesImpl categoryServicesImpl;

    @Autowired
    AnswerServicesImpl answerServicesImpl;

    @Autowired
    DifficultyServicesImpl difficultyServicesImpl;


    @ApiOperation(value = "find Question by id")
    @RequestMapping(value = "/Question/id/{id}", method = RequestMethod.GET)
    public QuestionDTO findQuestionById(@PathVariable Long id) {
        return questionServicesImpl.findById(id);
    }

    @ApiOperation(value = "delete Question by id")
    @RequestMapping(value = "/Question/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        questionServicesImpl.delete(id);
    }

    @ApiOperation(value = "find Question by name")
    @RequestMapping(value = "/Question/name/{name}", method = RequestMethod.GET)
    public List<QuestionDTO> findAllByName(@PathVariable String name) {
        return questionServicesImpl.findAllByName(name);
    }

    @ApiOperation(value = "get all Questions")
    @RequestMapping(value = "/Question/all", method = RequestMethod.GET)
    public List<QuestionDTO> findAllQuestion() {
        return questionServicesImpl.findAll();
    }

    @ApiOperation(value = "update a Question")
    @RequestMapping(value = "/Question/update", method = RequestMethod.POST)
    public QuestionDTO updateQuestion(@RequestBody QuestionDTO questionDTO) {
        return questionServicesImpl.update(questionDTO);
    }

    @ApiOperation(value = "add a Question")
    @RequestMapping(value = "/Question/{name}/{idCategory}/{idDifficulty}", method = RequestMethod.POST,
            consumes = "application/json")
    public ResponseEntity<QuestionDTO> addQuestion(@RequestBody Map<String,Boolean> listNameAnswers,
                               @PathVariable Long idCategory,
                               @PathVariable Long idDifficulty,
                              @PathVariable String name) {

        QuestionDTO questionDTO = new QuestionDTO();
        CategoryDTO categoryDTO = categoryServicesImpl.findById(idCategory);
        DifficultyDTO difficultyDTO = difficultyServicesImpl.findById(idDifficulty);

        questionDTO.setCategory(categoryDTO);
        questionDTO.setDifficulty(difficultyDTO);
        questionDTO.setName(name);

        AnswerDTO answerDTO = new AnswerDTO();
        List<AnswerDTO> listAnswers= new ArrayList<>();
        for (Map.Entry<String, Boolean> map : listNameAnswers.entrySet()) {

            answerDTO=new AnswerDTO();
            answerDTO.setGood(map.getValue());
            answerDTO.setName(map.getKey());
            listAnswers.add(answerDTO);
        }
        questionDTO.setAnswers(listAnswers);

        QuestionDTO responseQuestionDTO=questionServicesImpl.save(questionDTO);

        if(responseQuestionDTO==null){
            return ResponseEntity.noContent().build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/Question/id/{id}").
                buildAndExpand(responseQuestionDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }
}