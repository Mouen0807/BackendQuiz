package com.example.quizrest.ServiceImpl;

import DAO.CountryDAOI;
import DTO.CountryDTO;
import Entities.Country;
import Services.CountryServices;
import com.example.quizrest.Mapper.CountryMapper;
import com.example.quizrest.MapperImpl.CountryMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component
public class CountryServicesImpl implements CountryServices {

    CountryMapper countryMapper=new CountryMapperImpl();

    @Autowired
    CountryDAOI countryDAOI;

    @Override
    public CountryDTO save(CountryDTO entityDTO) {
        Country country = countryDAOI.findByName(entityDTO.getName());
        if(country == null)
            return countryMapper.toDTO(countryDAOI.save(countryMapper.toEntities(entityDTO)));
        else
            return countryMapper.toDTO(null);
    }

    @Override
    public CountryDTO update(CountryDTO entityDTO) {
        CountryDTO countryDTO=findById(entityDTO.getId());
        countryDTO.setId(entityDTO.getId());
        countryDTO.setName(entityDTO.getName());
        countryDAOI.save(countryMapper.toEntities(countryDTO));
        return countryDTO;
    }

    @Override
    public void delete(Long id) {
        countryDAOI.deleteById(id);
    }

    @Override
    public CountryDTO findById(Long id) {
        return countryMapper.toDTO(countryDAOI.getOne(id));
    }

    @Override
    public CountryDTO findByName(String name) {
        return countryMapper.toDTO(countryDAOI.findByName(name));
    }

    @Override
    public List<CountryDTO> findAll() {
        return countryMapper.toDTOList(countryDAOI.findAll());
    }

    @Override
    public List<CountryDTO> findAllByName(String name) {
        return countryMapper.toDTOList(countryDAOI.findByNameLike(name));
    }

}
