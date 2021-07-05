package com.example.quizrest.Controller;

import DTO.*;
import com.example.quizrest.ServiceImpl.*;
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

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @ApiOperation(value = "find Game by id")
    @RequestMapping(value = "/api/Game/id/{id}", method = RequestMethod.GET)
    public GameDTO findGameById(@PathVariable Long id) {
        logger.info("find Game by id: "+id);
        return gameServicesImpl.findById(id);
    }

    @ApiOperation(value = "delete Game by id")
    @RequestMapping(value = "/api/Game/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        logger.info("delete Game by id: "+id);
        gameServicesImpl.delete(id);
    }

    @ApiOperation(value = "get all Games")
    @GetMapping(value = "/api/Game/all")
    public List<GameDTO> findAllGame() {
        logger.info("get all Game");
        return gameServicesImpl.findAll();
    }




    @ApiOperation(value = "get all Games by categoryId and difficultyId")
    @GetMapping(value = "/api/Game/all/{categoryId}/{difficultyId}")
    public List<GameDTO> findAllGameByCategoryIdAndDifficultyId(@PathVariable Long categoryId,
                                                                @PathVariable Long difficultyId) {
        logger.info("get all Game by categoryId: "+categoryId + "difficultyId: "+difficultyId);
        return gameServicesImpl.findGamesByCategoryAndDifficulty(difficultyId, categoryId);
    }

    @ApiOperation(value= "get all Games by date range")
    @GetMapping(value = "/api/Game/Date/{dateStart}/{dateEnd}")
    public List<GameDTO> findGameByRange(@PathVariable Date dateStart,@PathVariable Date dateEnd){
        logger.info("get all Game in range dateStart: "+dateStart + " dateEnd: "+dateEnd);
        if(dateStart.before(dateEnd)){
            return gameServicesImpl.findByDateBetween(dateStart,dateEnd);
        }
        else
        {
            return null;
        }
    }


    @ApiOperation(value = "add a new Game")
    @RequestMapping(value = "/api/Game/new", method = RequestMethod.POST)
    public ResponseEntity<GameDTO> addGame(@RequestBody GameDTO gameDTO) {
        logger.info("add a new Game by Difficulty id: "+gameDTO.getDifficulty()+" Category id: "+gameDTO.getCategory());
        

        GameDTO responseGameDTO=gameServicesImpl.save(gameDTO);

        if(responseGameDTO==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/api/Game/id/{id}").
                buildAndExpand(responseGameDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "update a Game")
    @PostMapping(value = "/api/Game/update")
    public GameDTO updateGame(@RequestBody GameDTO gameDTO) {
        logger.info("udpate a Game");
        return gameServicesImpl.update(gameDTO);
    }

}