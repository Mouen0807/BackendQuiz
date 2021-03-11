package com.example.quizrest.Controller;

import DTO.AnswerDTO;
import com.example.quizrest.ServiceImpl.AnswerServicesImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


    @Api(description="Api management Answer")
    @RestController

    public class AnswerController {
        @Autowired
        AnswerServicesImpl answerServicesImpl;
        private static final Logger logger = LoggerFactory.getLogger(AnswerController.class);

        @ApiOperation(value="find Answer by id")
        @RequestMapping(value = "/Answer/id/{id}", method = RequestMethod.GET)
        public AnswerDTO findAnswerById(@PathVariable Long id) {
            logger.info("find Answer by id :"+id);
            return answerServicesImpl.findById(id);

        }

        @ApiOperation(value="delete Answer by id")
        @RequestMapping(value = "/Answer/delete/{id}", method = RequestMethod.GET)
        public void deleteById(@PathVariable Long id) {
            logger.info("Delete Answer by id :"+id );
            answerServicesImpl.delete(id);
        }

        @ApiOperation(value="find Answer by name")
        @RequestMapping( value="/Answer/name/{name}", method = RequestMethod.GET)
        public List<AnswerDTO> findAllByName(@PathVariable String name) {
            logger.info("find Answer by name :"+name );
            return answerServicesImpl.findAllByName(name);
        }

        @ApiOperation(value="get all Answers")
        @RequestMapping(value="/Answer/all", method = RequestMethod.GET)
        public List<AnswerDTO> findAllAnswer() {
            logger.info("get all Answers");
            return answerServicesImpl.findAll();
        }

        @ApiOperation(value="update a Answer")
        @RequestMapping(value = "/Answer/update", method = RequestMethod.POST)
        public AnswerDTO updateAnswer(@RequestBody AnswerDTO answerDTO) {
            logger.info("update a answer");
            return answerServicesImpl.update(answerDTO);
        }

        @ApiOperation(value="add a Answer")
        @RequestMapping(value = "/Answer/{name}/{isGood}", method = RequestMethod.POST)
        public ResponseEntity<AnswerDTO> addAnswer(@PathVariable String name, @PathVariable boolean isGood) {
            logger.info("add Answer  name:"+name+ " isGood : "+ isGood);
            AnswerDTO answerDTO=new AnswerDTO();
            answerDTO.setGood(isGood);
            answerDTO.setName(name);
            

            AnswerDTO responseAnswerDTO=answerServicesImpl.save(answerDTO);

            if(responseAnswerDTO==null){
                return ResponseEntity.noContent().build();
            }

            URI location= ServletUriComponentsBuilder.fromPath("/Answer/id/{id}").
                    buildAndExpand(responseAnswerDTO.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }
}
