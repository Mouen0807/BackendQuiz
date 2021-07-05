package com.example.quizrest.Controller;

import DTO.*;
import com.example.quizrest.ServiceImpl.CategoryServicesImpl;
import com.example.quizrest.ServiceImpl.DifficultyServicesImpl;
import com.example.quizrest.ServiceImpl.QuestionServicesImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(description="Api management Question")
@RestController

public class QuestionController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    QuestionServicesImpl questionServicesImpl;

    @Autowired
    CategoryServicesImpl categoryServicesImpl;


    @Autowired
    DifficultyServicesImpl difficultyServicesImpl;


    @ApiOperation(value = "find Question by id")
    @RequestMapping(value = "/api/Question/id/{id}", method = RequestMethod.GET)
    public QuestionDTO findQuestionById(@PathVariable Long id) {
        logger.info("find Question by: "+id);
        return questionServicesImpl.findById(id);
    }

    @ApiOperation(value = "delete Question by id")
    @RequestMapping(value = "/api/Question/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        logger.info("delete Question by: "+id);
        questionServicesImpl.delete(id);
    }

    @ApiOperation(value = "find Question by name")
    @RequestMapping(value = "/api/Question/name/{name}", method = RequestMethod.GET)
    public List<QuestionDTO> findAllByName(@PathVariable String name) {
        logger.info("find Question by name: "+name);
        return questionServicesImpl.findAllByName(name);
    }

    @ApiOperation(value = "get all Questions")
    @RequestMapping(value = "/api/Question/all", method = RequestMethod.GET)
    public List<QuestionDTO> findAllQuestion() {
        logger.info("get all Question");
        return questionServicesImpl.findAll();
    }

    @ApiOperation(value = "update a Question")
    @RequestMapping(value = "/api/Question/update", method = RequestMethod.POST)
    public QuestionDTO updateQuestion(@RequestBody QuestionDTO questionDTO) {
        logger.info("update a Question");
        return questionServicesImpl.update(questionDTO);
    }

    @ApiOperation(value = "add a Question")
    @RequestMapping(value = "/api/Question/new", method = RequestMethod.POST,
            consumes = "application/json")
    public ResponseEntity<QuestionDTO> addQuestion(@RequestBody QuestionDTO questionDTO) {

        logger.info("add a Question with name: "+ questionDTO.getConcatenedAnswers()+" CategoryId: "+ questionDTO.getCategory().getId()
                + " DifficultyId: "+ questionDTO.getDifficulty().getId());
        QuestionDTO responseQuestionDTO = questionServicesImpl.save(questionDTO);

        if(responseQuestionDTO==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/api/Question/id/{id}").
                buildAndExpand(responseQuestionDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }
}