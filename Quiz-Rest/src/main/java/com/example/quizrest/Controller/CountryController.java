package com.example.quizrest.Controller;


import DTO.CountryDTO;
import com.example.quizrest.ServiceImpl.CountryServicesImpl;
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

@Api(description="Api management Country")
@RestController
public class CountryController {

    @Autowired
    CountryServicesImpl countryServicesImpl;

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @ApiOperation(value="find Country by id")
    @RequestMapping(value = "/api/Country/id/{id}", method = RequestMethod.GET)
    public CountryDTO findCountryById(@PathVariable Long id) {
        logger.info("find Country by id: "+ id);
        return countryServicesImpl.findById(id);
    }

    @ApiOperation(value="delete Country by id")
    @RequestMapping(value = "/api/Country/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        logger.info("delete Country by id: "+ id);
        countryServicesImpl.delete(id);
    }

    @ApiOperation(value="find Country by name")
    @RequestMapping( value="/api/Country/name/{name}", method = RequestMethod.GET)
    public List<CountryDTO> findAllByName(@PathVariable String name) {
        logger.info("find all Country by name: "+ name);
        return countryServicesImpl.findAllByName(name);
    }

    @ApiOperation(value="get all Countries")
    @GetMapping(value="/api/Country/all")
    public List<CountryDTO> findAllCountry() {
        logger.info("get all Country");
        return countryServicesImpl.findAll();
    }

    @ApiOperation(value="add a new Country")
    @RequestMapping(value="/api/Country/new", method = RequestMethod.POST)
    public ResponseEntity<CountryDTO> addCountry(@RequestBody CountryDTO countryDTO) {
        logger.info("add Country with name: "+ countryDTO.getName());

        CountryDTO responseCountryDTO=countryServicesImpl.save(countryDTO);
        if(responseCountryDTO==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/api/Country/id/{id}").
                      buildAndExpand(responseCountryDTO.getId())
                      .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value="update a Country")
    @PostMapping(value = "/api/Country/update")
    public CountryDTO updateCountry(@RequestBody CountryDTO countryDTO) {
        logger.info("update a Country");
        return countryServicesImpl.update(countryDTO);
    }

}
