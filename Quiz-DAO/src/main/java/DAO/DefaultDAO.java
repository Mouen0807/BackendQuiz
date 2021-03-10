package DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DefaultDAO<T,I>  {

    public void save(T t);
    public List<T> findAll();
    public T findById(I id);
    public T update(T t);
    public void delete(I id);
    public int count();
    public T findByName(String name);
    public List<T> findAllByName(String name);

}
