package Services;

import java.util.List;

public interface DefaultServices<E,T> {

    public E save(E entity);
    public E update(E entity);
    public void delete(T id);
    public E findById(T id);
    public E findByName(String name);
    public List<E> findAll();
    public List<E> findAllByName(String name);

}
