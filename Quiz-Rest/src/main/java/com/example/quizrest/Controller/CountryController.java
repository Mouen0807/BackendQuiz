package com.example.quizrest.Controller;


import DTO.CountryDTO;
import com.example.quizrest.ServiceImpl.CountryServicesImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation(value="find Country by id")
    @RequestMapping(value = "/Country/id/{id}", method = RequestMethod.GET)
    public CountryDTO findCountryById(@PathVariable Long id) {
        return countryServicesImpl.findById(id);
    }

    @ApiOperation(value="delete Country by id")
    @RequestMapping(value = "/Country/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
         countryServicesImpl.delete(id);
    }

    @ApiOperation(value="find Country by name")
    @RequestMapping( value="/Country/name/{name}", method = RequestMethod.GET)
    public List<CountryDTO> findAllByName(@PathVariable String name) {
        return countryServicesImpl.findAllByName(name);
    }

    @ApiOperation(value="get all Countries")
    @GetMapping(value="/Country/all")
    public List<CountryDTO> findAllCountry() {
        return countryServicesImpl.findAll();
    }

    @ApiOperation(value="add a new Country")
    @RequestMapping(value="/Country/name/{name}", method = RequestMethod.POST)
    public ResponseEntity<CountryDTO> addCountry(@PathVariable String name) {
        CountryDTO countryDTO=new CountryDTO();
        countryDTO.setName(name);
        CountryDTO responseCountryDTO=countryServicesImpl.save(countryDTO);

        if(responseCountryDTO==null){
            return ResponseEntity.noContent().build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/Country/id/{id}").
                      buildAndExpand(responseCountryDTO.getId())
                      .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value="update a Country")
    @PostMapping(value = "/Country/update")
    public CountryDTO updateCountry(@RequestBody CountryDTO countryDTO) {
        return countryServicesImpl.update(countryDTO);
    }

}