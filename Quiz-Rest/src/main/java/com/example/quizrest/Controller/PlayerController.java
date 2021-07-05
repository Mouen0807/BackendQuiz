package com.example.quizrest.Controller;

import DTO.CategoryDTO;
import DTO.CountryDTO;
import DTO.PlayerDTO;
import com.example.quizrest.Configuration.Authentication.JwtRequest;
import com.example.quizrest.ServiceImpl.CountryServicesImpl;
import com.example.quizrest.ServiceImpl.PlayerServicesImpl;
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

@Api(description="Api management Player")
@RestController
public class PlayerController {

    @Autowired
    PlayerServicesImpl playerServicesImpl;

    @Autowired
    CountryServicesImpl countryServicesImpl;

    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @ApiOperation(value = "find Player by id")
    @RequestMapping(value = "/api/Player/id/{id}", method = RequestMethod.GET)
    public PlayerDTO findPlayerById(@PathVariable Long id) {
        logger.info("find Player by id: "+id);
        return playerServicesImpl.findById(id);
    }

    @ApiOperation(value = "delete Player by id")
    @RequestMapping(value = "/api/Player/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        logger.info("delete Player by id: "+id);
        playerServicesImpl.delete(id);
    }

    @ApiOperation(value = "find Player by name")
    @RequestMapping(value = "/api/Player/name/{name}", method = RequestMethod.GET)
    public List<PlayerDTO> findAllByName(@PathVariable String name) {
        logger.info("find Player by name: "+name);
        return playerServicesImpl.findAllByName(name);
    }

    @ApiOperation(value = "get all Players")
    @GetMapping(value = "/api/Player/all")
    public List<PlayerDTO> findAllPlayer() {
        logger.info("get all Players");
        return playerServicesImpl.findAll();
    }

    @ApiOperation(value = "get all Players by country id")
    @GetMapping(value = "/api/Player/{countryId}")
    public List<PlayerDTO> findAllPlayer(@PathVariable Long countryId) {
        logger.info("get all Players by country id: "+countryId);
        return playerServicesImpl.sortPlayerByCountry(countryId);
    }

    @ApiOperation(value="add a new Player")
    @RequestMapping(value="/api/Player/new", method = RequestMethod.POST)
    public ResponseEntity<CategoryDTO> addPlayer(@RequestBody PlayerDTO playerDTO) {
        logger.info("add new Player");

        PlayerDTO responsePlayerDTO=playerServicesImpl.save(playerDTO);

        if(responsePlayerDTO==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/Category/id/{id}").
                buildAndExpand(responsePlayerDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

    @ApiOperation(value = "login player")
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<PlayerDTO> login(@RequestBody JwtRequest jwtRequest) {
        logger.info("player register");
        PlayerDTO responsePlayerDTO=playerServicesImpl.findByNameAndPassword(jwtRequest.getUsername(), jwtRequest.getUsername());

        if(responsePlayerDTO==null){
            return ResponseEntity.noContent().build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/api/Player/id/{id}").
                buildAndExpand(responsePlayerDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

    @ApiOperation(value = "update a Player")
    @PostMapping(value = "/api/Player/update")
    public PlayerDTO updatePlayer(@RequestBody PlayerDTO playerDTO) {
        logger.info("update a Player");
        return playerServicesImpl.update(playerDTO);
    }

}
