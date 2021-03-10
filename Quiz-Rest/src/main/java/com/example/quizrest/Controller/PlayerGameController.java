package com.example.quizrest.Controller;

import DTO.*;
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

@Api(description="Api management PlayerGame")
@RestController
public class PlayerGameController {

    @Autowired
    PlayerGameServicesImpl playerGameServicesImpl;

    @Autowired
    GameServicesImpl gameServicesImpl;

    @Autowired
    PlayerServicesImpl playerServicesImpl;


    @ApiOperation(value = "find PlayerGame by id")
    @RequestMapping(value = "/PlayerGame/id/{id}", method = RequestMethod.GET)
    public PlayerGameDTO findPlayerGameById(@PathVariable Long id) {
        return playerGameServicesImpl.findById(id);
    }

    @ApiOperation(value = "delete PlayerGame by id")
    @RequestMapping(value = "/PlayerGame/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        playerGameServicesImpl.delete(id);
    }
    
    @ApiOperation(value = "get all PlayerGames")
    @GetMapping(value = "/PlayerGame/all")
    public List<PlayerGameDTO> findAllPlayerGame() {
        return playerGameServicesImpl.findAll();
    }

    @ApiOperation(value = "get all PlayerGames by playerId")
    @GetMapping(value = "/PlayerGame/all/{playerId}")
    public List<PlayerGameDTO> findAllPlayerGameByPlayerId(@PathVariable Long playerId) {
        return playerGameServicesImpl.findAllByPlayerId(playerId);
    }

    

    @ApiOperation(value = "add a new PlayerGame")
    @RequestMapping(value = "/PlayerGame/{idPlayer}/{idGame}/{secondEffective}/{score}", method = RequestMethod.POST)
    public ResponseEntity<PlayerGameDTO> addPlayerGame(@PathVariable Long idPlayer,
                                       @PathVariable Long idGame,
                                       @PathVariable int secondEffective,
                                       @PathVariable int score) {

        GameDTO gameDTO = gameServicesImpl.findById(idGame);
        PlayerDTO playerDTO = playerServicesImpl.findById(idPlayer);

        PlayerGameDTO playerGameDTO = new PlayerGameDTO();

        playerGameDTO.setGame(gameDTO);
        playerGameDTO.setPlayer(playerDTO);
        playerGameDTO.setScore(score);
        playerGameDTO.setSecondEffective(secondEffective);

        PlayerGameDTO responsePlayerGameDTO=playerGameServicesImpl.save(playerGameDTO);

        if(responsePlayerGameDTO==null){
            return ResponseEntity.noContent().build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/PlayerGame/id/{id}").
                buildAndExpand(responsePlayerGameDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "update a PlayerGame")
    @PostMapping(value = "/PlayerGame/update")
    public PlayerGameDTO updatePlayerGame(@RequestBody PlayerGameDTO playerGameDTO) {
        return playerGameServicesImpl.update(playerGameDTO);
    }

}