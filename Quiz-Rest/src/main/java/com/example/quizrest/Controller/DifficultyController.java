package com.example.quizrest.Controller;

import DTO.DifficultyDTO;
import DTO.DifficultyDTO;
import com.example.quizrest.ServiceImpl.DifficultyServicesImpl;
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

@Api(description="Api management Difficulty")
@RestController
public class DifficultyController {
    @Autowired
    DifficultyServicesImpl difficultyServicesImpl;

    private static final Logger logger = LoggerFactory.getLogger(DifficultyController.class);

    @ApiOperation(value="find Difficulty by id")
    @RequestMapping(value = "/api/Difficulty/id/{id}", method = RequestMethod.GET)
    public DifficultyDTO findDifficultyById(@PathVariable Long id) {
        logger.info("find Difficulty by id: "+id);
        return difficultyServicesImpl.findById(id);
    }

    @ApiOperation(value="delete Difficulty by id")
    @RequestMapping(value = "/api/Difficulty/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        logger.info("delete Difficulty by id:" +id);
        difficultyServicesImpl.delete(id);
    }

    @ApiOperation(value="find Difficulty by name")
    @RequestMapping( value="/api/Difficulty/name/{name}", method = RequestMethod.GET)
    public List<DifficultyDTO> findAllByName(@PathVariable String name) {
        logger.info("find Difficulty by id:" +name);
        return difficultyServicesImpl.findAllByName(name);
    }

    @ApiOperation(value="get all Difficulties")
    @GetMapping(value="/api/Difficulty/all")
    public List<DifficultyDTO> findAllDifficulty() {
        logger.info("get all Difficulty");
        return difficultyServicesImpl.findAll();
    }

    @ApiOperation(value="add a new Difficulty")
    @RequestMapping(value="/api/Difficulty/new", method = RequestMethod.POST)
    public ResponseEntity<DifficultyDTO> addDifficulty(@RequestBody DifficultyDTO difficultyDTO) {
        logger.info("add a new Difficulty name: "+difficultyDTO.getName()+" numberQuestions: "+
                difficultyDTO.getNumberQuestions()+" times(seconds) :"+difficultyDTO.getSeconds() );
        DifficultyDTO responseDifficultyDTO=difficultyServicesImpl.save(difficultyDTO);

        if(responseDifficultyDTO==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/api/Difficulty/id/{id}").
                buildAndExpand(responseDifficultyDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value="update a Difficulty")
    @PostMapping(value = "/api/Difficulty/update")
    public DifficultyDTO updateDifficulty(@RequestBody DifficultyDTO difficultyDTO) {
        logger.info("update a Difficulty");
        return difficultyServicesImpl.update(difficultyDTO);
    }


}
