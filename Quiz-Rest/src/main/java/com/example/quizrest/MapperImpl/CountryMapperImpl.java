package com.example.quizrest.MapperImpl;

import DTO.CountryDTO;

import Entities.Country;
import com.example.quizrest.Mapper.CountryMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-06T20:25:58+0100",
    comments = "version: 1.4.0.Beta3, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryDTO toDTO(Country entity) {
        if ( entity == null ) {
            return null;
        }

        CountryDTO countryDTO = new CountryDTO();

        if ( entity.getId() != null ) {
            countryDTO.setId( entity.getId() );
        }
        countryDTO.setName( entity.getName() );

        return countryDTO;
    }

    @Override
    public Country toEntities(CountryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Country country = new Country();

        country.setId( dto.getId() );
        country.setName( dto.getName() );

        return country;
    }

    @Override
    public List<CountryDTO> toDTOList(List<Country> entitiesList) {
        if ( entitiesList == null ) {
            return null;
        }

        List<CountryDTO> list = new ArrayList<CountryDTO>( entitiesList.size() );
        for ( Country country : entitiesList ) {
            list.add( toDTO( country ) );
        }

        return list;
    }

    @Override
    public List<Country> toEntitiesList(List<CountryDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Country> list = new ArrayList<Country>( dtoList.size() );
        for ( CountryDTO countryDTO : dtoList ) {
            list.add( toEntities( countryDTO ) );
        }

        return list;
    }
}
