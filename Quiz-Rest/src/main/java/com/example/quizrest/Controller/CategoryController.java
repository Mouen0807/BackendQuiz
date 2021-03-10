package com.example.quizrest.Controller;

import DTO.CategoryDTO;
import Entities.Category;
import com.example.quizrest.ServiceImpl.CategoryServicesImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description="Api management Category")
@RestController
public class CategoryController {

    @Autowired
    CategoryServicesImpl categoryServicesImpl;

    @ApiOperation(value="find Category by id")
    @RequestMapping(value = "/Category/id/{id}", method = RequestMethod.GET)
    public CategoryDTO findCountryById(@PathVariable Long id) {
        return categoryServicesImpl.findById(id);
    }

    @ApiOperation(value="delete Category by id")
    @RequestMapping(value = "/Category/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        categoryServicesImpl.delete(id);
    }

    @ApiOperation(value="find Category by name")
    @RequestMapping( value="/Category/name/{name}", method = RequestMethod.GET)
    public List<CategoryDTO> findAllByName(@PathVariable String name) {
        return categoryServicesImpl.findAllByName(name);
    }

    @ApiOperation(value="get all categories")
    @GetMapping(value="/Category/all")
    public List<CategoryDTO> findAllCountry() {
        return categoryServicesImpl.findAll();
    }

    @ApiOperation(value="add a new Category")
    @RequestMapping(value="/Category/name/{name}", method = RequestMethod.POST)
    public CategoryDTO addCategory(@PathVariable String name) {
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setName(name);
        return categoryServicesImpl.save(categoryDTO);
    }

    @ApiOperation(value="update a Category")
    @PostMapping(value = "/Category/update")
    public CategoryDTO updateCountry(@RequestBody CategoryDTO categoryDTO) {
        return categoryServicesImpl.update(categoryDTO);
    }
}
