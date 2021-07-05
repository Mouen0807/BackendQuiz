package com.example.quizrest.Controller;

import DTO.CategoryDTO;
import com.example.quizrest.ServiceImpl.CategoryServicesImpl;
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


    @Api(description="Api management Category")
    @RestController
    public class CategoryController {
    
        @Autowired
        CategoryServicesImpl categoryServicesImpl;

        private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    
        @ApiOperation(value="find Category by id")
        @RequestMapping(value = "/api/Category/id/{id}", method = RequestMethod.GET)
        public CategoryDTO findCountryById(@PathVariable Long id) {
            logger.info("find Category by id :"+ id);
            return categoryServicesImpl.findById(id);
        }
    
        @ApiOperation(value="delete Category by id")
        @RequestMapping(value = "/api/Category/delete/{id}", method = RequestMethod.GET)
        public void deleteById(@PathVariable Long id) {
            logger.info("delete Category by id :"+ id);
            categoryServicesImpl.delete(id);
        }
    
        @ApiOperation(value="find Category by name")
        @RequestMapping( value="/api/Category/name/{name}", method = RequestMethod.GET)
        public List<CategoryDTO> findAllByName(@PathVariable String name) {
            logger.info("find All Category by name :"+ name);
            return categoryServicesImpl.findAllByName(name);
        }
    
        @ApiOperation(value="get all categories")
        @GetMapping(value="/api/Category/all")
        public List<CategoryDTO> findAllCountry() {
            logger.info("get all Category");
            return categoryServicesImpl.findAll();
        }
    
        @ApiOperation(value="add a new Category")
        @RequestMapping(value="/api/Category/new", method = RequestMethod.POST)
        public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO) {
            logger.info("add new Category :"+ categoryDTO.getName());

            CategoryDTO responseCategoryDTO=categoryServicesImpl.save(categoryDTO);

            if(responseCategoryDTO==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }

            URI location= ServletUriComponentsBuilder.fromPath("/api/Category/id/{id}").
                    buildAndExpand(responseCategoryDTO.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
            
        }
    
        @ApiOperation(value="update a Category")
        @PostMapping(value = "/api/Category/update")
        public CategoryDTO updateCountry(@RequestBody CategoryDTO categoryDTO) {
            logger.info("update a Category");
            return categoryServicesImpl.update(categoryDTO);
        }
    }
