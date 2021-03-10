package DAOImpl;


import DAO.DefaultDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;


public abstract class DefaultDAOImpl<T,I> implements DefaultDAO<T,I> {

    protected  final Logger logger = LoggerFactory.getLogger(this.getClass());


    @PersistenceContext
    protected EntityManager entityManager;
    protected Class<T> clz;

    public DefaultDAOImpl(Class<T> clz) {
        this.clz = clz;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Transactional
    public void save(T t){
        logger.info(String.format("JPA creating %s", clz.getName()));
        if(entityManager==null)
        {
            logger.info(String.format("Error entityManager is null for %s", clz.getName()));
        }
        getEntityManager().persist(t);
    }


    @Transactional
    public List<T> findAll(){
        logger.info("JPA Loading all %s", clz.getName());
        return getEntityManager().createQuery("from " + clz.getName(), clz).getResultList();

    }

    @Transactional
    public T findById(I id){
        logger.info(String.format("JPA Loading %s %s.", clz.getName(), id));
        return getEntityManager().find(clz, id);
    }

    @Transactional
    public T update(T t){
        logger.info(String.format("JPA updating "+this.clz.getName()+" %s.", t));
        return (T)getEntityManager().merge(t);
    }

    @Transactional
    public void delete(I id){
        logger.info(String.format("JPA delete %s %s.", clz.getName(), id));
        T t = getEntityManager().find(clz, id);
        if (t == null) {
            throw new NoResultException(String.format("%s %s does not exist.", clz.getName(), id));
        }
        getEntityManager().remove(id);

    }

    @Transactional
    public int count(){
        TypedQuery<Long> q = getEntityManager().createQuery("select count(obj) from "+ clz.getName()+" obj", Long.class);
        return q.getSingleResult().intValue();
    }

    @Transactional
    public T findByName(String name){
        logger.info(String.format("JPA Loading %s %s.", clz.getName(), name));
        TypedQuery<T> q = getEntityManager().createQuery("SELECT obj FROM " +
                clz.getName() + " obj WHERE obj.name = :name", clz);
        q.setParameter("name", name);
        return q.getSingleResult();
    }

    @Transactional
    public List<T> findAllByName(String name){
        logger.info(String.format("JPA Loading all %s with name %s.", clz.getName(), name));
        TypedQuery<T> q = getEntityManager().createQuery("SELECT obj FROM " + clz.getName() + " obj WHERE obj.name = :name", clz);
        q.setParameter("name", name);
        return q.getResultList();
    }

    public Class<T> getClz() {
        return clz;
    }

    public void setClz(Class<T> clz) {
        this.clz = clz;
    }
}
