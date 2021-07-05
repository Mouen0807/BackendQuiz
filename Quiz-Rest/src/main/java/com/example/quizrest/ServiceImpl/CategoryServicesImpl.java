package com.example.quizrest.ServiceImpl;
import DAO.CategoryDAOI;
import DAOImpl.CategoryDAOImpl;
import DTO.CategoryDTO;
import Entities.Category;
import Services.CategoryServices;
import com.example.quizrest.Mapper.CategoryMapper;
import com.example.quizrest.MapperImpl.CategoryMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CategoryServicesImpl implements CategoryServices {

    CategoryMapper categoryMapper=new CategoryMapperImpl();

    @Autowired
    CategoryDAOI categoryDAOI;

    @Override
    public CategoryDTO save(CategoryDTO entityDTO) {
        Category category = categoryDAOI.findByName(entityDTO.getName());
        if(category!=null){
            return categoryMapper.toDTO(null);
        }
        return categoryMapper.toDTO(categoryDAOI.save(categoryMapper.toEntities(entityDTO)));
    }

    @Override
    public CategoryDTO update(CategoryDTO entityDTO) {
        CategoryDTO categoryDTO=findById(entityDTO.getId());
        categoryDTO.setId(entityDTO.getId());
        categoryDTO.setName(entityDTO.getName());
        categoryDAOI.save(categoryMapper.toEntities(categoryDTO));
        return findById(entityDTO.getId());
    }

    @Override
    public void delete(Long id) {
        categoryDAOI.deleteById(id);
    }

    @Override
    public CategoryDTO findById(Long id) {
        return categoryMapper.toDTO(categoryDAOI.getOne(id));
    }

    @Override
    public CategoryDTO findByName(String name) {
        return categoryMapper.toDTO(categoryDAOI.findByName(name));
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryMapper.toDTOList(categoryDAOI.findAll());
    }

    @Override
    public List<CategoryDTO> findAllByName(String name) {
        return categoryMapper.toDTOList(categoryDAOI.findByNameLike(name));
    }
}
