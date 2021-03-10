package com.example.quizrest.MapperImpl;


import DTO.CategoryDTO;
import Entities.Category;
import com.example.quizrest.Mapper.CategoryMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-06T20:25:59+0100",
    comments = "version: 1.4.0.Beta3, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO toDTO(Category entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( entity.getId() );
        categoryDTO.setName( entity.getName() );

        return categoryDTO;
    }

    @Override
    public Category toEntities(CategoryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( dto.getId() );
        category.setName( dto.getName() );

        return category;
    }

    @Override
    public List<CategoryDTO> toDTOList(List<Category> entitiesList) {
        if ( entitiesList == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( entitiesList.size() );
        for ( Category category : entitiesList ) {
            list.add( toDTO( category ) );
        }

        return list;
    }

    @Override
    public List<Category> toEntitiesList(List<CategoryDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( dtoList.size() );
        for ( CategoryDTO categoryDTO : dtoList ) {
            list.add( toEntities( categoryDTO ) );
        }

        return list;
    }
}
