package com.example.quizrest.Controller;

import DTO.CountryDTO;
import DTO.PlayerDTO;
import com.example.quizrest.ServiceImpl.CountryServicesImpl;
import com.example.quizrest.ServiceImpl.PlayerServicesImpl;
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

@Api(description="Api management Player")
@RestController
public class PlayerController {

    @Autowired
    PlayerServicesImpl playerServicesImpl;

    @Autowired
    CountryServicesImpl countryServicesImpl;

    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @ApiOperation(value = "find Player by id")
    @RequestMapping(value = "/Player/id/{id}", method = RequestMethod.GET)
    public PlayerDTO findPlayerById(@PathVariable Long id) {
        logger.info("find Player by id: "+id);
        return playerServicesImpl.findById(id);
    }

    @ApiOperation(value = "delete Player by id")
    @RequestMapping(value = "/Player/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        logger.info("delete Player by id: "+id);
        playerServicesImpl.delete(id);
    }

    @ApiOperation(value = "find Player by name")
    @RequestMapping(value = "/Player/name/{name}", method = RequestMethod.GET)
    public List<PlayerDTO> findAllByName(@PathVariable String name) {
        logger.info("find Player by name: "+name);
        return playerServicesImpl.findAllByName(name);
    }

    @ApiOperation(value = "get all Players")
    @GetMapping(value = "/Player/all")
    public List<PlayerDTO> findAllPlayer() {
        logger.info("get all Players");
        return playerServicesImpl.findAll();
    }

    @ApiOperation(value = "get all Players by country id")
    @GetMapping(value = "/Player/{countryId}")
    public List<PlayerDTO> findAllPlayer(@PathVariable Long countryId) {
        logger.info("get all Players by country id: "+countryId);
        return playerServicesImpl.sortPlayerByCountry(countryId);
    }


    @ApiOperation(value = "add a new Player")
    @RequestMapping(value = "/Player/{name}/{email}/{idCountry}", method = RequestMethod.POST)
    public ResponseEntity<PlayerDTO> addPlayer(@PathVariable String name,
                                @PathVariable String email,
                                        @PathVariable Long idCountry) {
        logger.info("add new Player with name: "+name+ " email: "+email+ "idCountry: "+idCountry);
        CountryDTO countryDTO=countryServicesImpl.findById(idCountry);
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName(name);
        playerDTO.setMail(email);
        playerDTO.setCountry(countryDTO);

        PlayerDTO responseCountryDTO=playerServicesImpl.save(playerDTO);

        if(responseCountryDTO==null){
            return ResponseEntity.noContent().build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/Player/id/{id}").
                buildAndExpand(responseCountryDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

    @ApiOperation(value = "update a Player")
    @PostMapping(value = "/Player/update")
    public PlayerDTO updatePlayer(@RequestBody PlayerDTO playerDTO) {
        logger.info("update a Player");
        return playerServicesImpl.update(playerDTO);
    }

}
