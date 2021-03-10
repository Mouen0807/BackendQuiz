package DAOImpl;

import DAO.PlayerGameDAOI;

import Entities.PlayerGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PlayerGameDAOImpl{}/* implements PlayerGameDAOI {

    protected  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    protected EntityManager entityManager;
    //public PlayerGame playerGame;


    public PlayerGameDAOImpl(){

        //this.entityManager=entityManager;
    }

    public void save(PlayerGame playerGame){
        logger.info(String.format("JPA creating %s",playerGame.getClass().getName() ));
        entityManager.persist(playerGame);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<PlayerGame> findAll() {
        logger.info("JPA Loading all com.example.quizEntities.Entities.PlayerGame");
        return getEntityManager().createQuery("SELECT playerGame FROM PlayerGame playerGame").getResultList();
    }

    public List<PlayerGame> findByPlayerId(Long id) {
        logger.info("JPA Loading all com.example.quizEntities.Entities.PlayerGame for player "+ id);
        return getEntityManager().createQuery("SELECT playerGame FROM PlayerGame playerGame" +
                " WHERE playerGame.player.id = :id", PlayerGame.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<PlayerGame> findByGameId(Long id){
        logger.info("JPA Loading all com.example.quizEntities.Entities.PlayerGame for com.example.quizEntities.Entities.Game "+ id);
        return getEntityManager().createQuery("SELECT playerGame FROM PlayerGame playerGame" +
                " WHERE playerGame.game.id = :id", PlayerGame.class)
                .setParameter("id", id)
                .getResultList();
    };

    public PlayerGame update(PlayerGame playerGame) {
        logger.info(String.format("JPA updating com.example.quizEntities.Entities.PlayerGame"+playerGame.toString()));
        return (PlayerGame) getEntityManager().merge(playerGame);
    }

    public void delete(Long Playerid, Long Gameid) {
        logger.info(String.format("JPA delete com.example.quizEntities.Entities.PlayerGame for Playerid"+Playerid+ " for Gameid "+ Gameid));
        int isSuccessful = entityManager.createQuery("delete from PlayerGame p where" +
                " p.player.id=:Playerid and p.game.id=:Gameid")
                .setParameter("Playerid", Playerid)
                .setParameter("Gameid", Gameid)
                .executeUpdate();
        if (isSuccessful == 0) {
            throw new NoResultException(" product modified concurrently");
        }
        else{
            throw new NoResultException(String.format("com.example.quizEntities.Entities.PlayerGame with player "+ Playerid +"and" +
                    " com.example.quizEntities.Entities.Game "+Gameid+" does not exist."));
        }
    }
}
*/