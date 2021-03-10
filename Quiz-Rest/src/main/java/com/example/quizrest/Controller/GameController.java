package com.example.quizrest.Controller;

import DTO.*;
import Services.CategoryServices;
import Services.QuestionServices;
import com.example.quizrest.ServiceImpl.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Api(description="Api management Game")
@RestController
public class GameController {

    @Autowired
    GameServicesImpl gameServicesImpl;

    @Autowired
    DifficultyServicesImpl difficultyServicesImpl;

    @Autowired
    CategoryServicesImpl categoryServicesImpl;

    @Autowired
    QuestionServicesImpl questionServicesImpl;

    @ApiOperation(value = "find Game by id")
    @RequestMapping(value = "/Game/id/{id}", method = RequestMethod.GET)
    public GameDTO findGameById(@PathVariable Long id) {
        return gameServicesImpl.findById(id);
    }

    @ApiOperation(value = "delete Game by id")
    @RequestMapping(value = "/Game/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        gameServicesImpl.delete(id);
    }

    @ApiOperation(value = "get all Games")
    @GetMapping(value = "/Game/all")
    public List<GameDTO> findAllGame() {
        return gameServicesImpl.findAll();
    }




    @ApiOperation(value = "get all Games by categoryId and difficultyId")
    @GetMapping(value = "/Game/all/{categoryId}/{difficultyId}")
    public List<GameDTO> findAllGameByCategoryIdAndDifficultyId(@PathVariable Long categoryId,
                                                                @PathVariable Long difficultyId) {
        return gameServicesImpl.findGamesByCategoryAndDifficulty(difficultyId, categoryId);
    }

    @ApiOperation(value= "get all Games by date range")
    @GetMapping(value = "/Game/Date/{dateStart}/{dateEnd}")
    public List<GameDTO> findGameByRange(@PathVariable Date dateStart,@PathVariable Date dateEnd){
        if(dateStart.before(dateEnd)){
            return gameServicesImpl.findByDateBetween(dateStart,dateEnd);
        }
        else
        {
            return null;
        }
    }


    @ApiOperation(value = "add a new Game")
    @RequestMapping(value = "/Game/{idDifficulty}/{idCategory}", method = RequestMethod.POST)
    public ResponseEntity<GameDTO> addGame(@PathVariable Long idCategory,
                           @PathVariable Long idDifficulty) {

        CategoryDTO categoryDTO = categoryServicesImpl.findById(idCategory);
        DifficultyDTO difficultyDTO = difficultyServicesImpl.findById(idDifficulty);

        List<QuestionDTO> listQuestionDTOTmp = questionServicesImpl.
                findQuestionsByCategoryAndDifficulty(idDifficulty, idCategory);
        Collections.shuffle(listQuestionDTOTmp);

        int numberQuestionsGame=Math.min(difficultyDTO.getNumberQuestions(),listQuestionDTOTmp.size());
        List<QuestionDTO> listQuestionDTO=new ArrayList<>();

        for (int i=0;i<numberQuestionsGame;i++){
            listQuestionDTO.add(listQuestionDTOTmp.get(i));
        }
        GameDTO gameDTO = new GameDTO();
        long millis=System.currentTimeMillis();// to get the local date
        gameDTO.setDate(new java.util.Date(millis));

        gameDTO.setCategory(categoryDTO);
        gameDTO.setDifficulty(difficultyDTO);
        gameDTO.setQuestions(listQuestionDTO);

        GameDTO responseGameDTO=gameServicesImpl.save(gameDTO);

        if(responseGameDTO==null){
            return ResponseEntity.noContent().build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/Game/id/{id}").
                buildAndExpand(responseGameDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "update a Game")
    @PostMapping(value = "/Game/update")
    public GameDTO updateGame(@RequestBody GameDTO gameDTO) {
        return gameServicesImpl.update(gameDTO);
    }

}