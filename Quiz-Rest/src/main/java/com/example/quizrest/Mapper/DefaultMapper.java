package com.example.quizrest.Mapper;



import java.util.List;

public interface DefaultMapper<D,E>{

    public D toDTO(E entity);
    public E toEntities(D dto);

    public List<D> toDTOList(List<E> entitiesList);
    public List<E> toEntitiesList(List<D> dtoList);


}
