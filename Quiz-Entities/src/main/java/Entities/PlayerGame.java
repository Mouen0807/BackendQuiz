package Entities;

import javax.persistence.*;
import java.io.Serializable;
//import java.util.Objects;

@Entity

public class PlayerGame implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Player player ;
    @ManyToOne
    private Game game ;

    private int Score;
    private int secondEffective;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getSecondEffective() {
        return secondEffective;
    }

    public void setSecondEffective(int secondEffective) {
        this.secondEffective = secondEffective;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerGame that = (PlayerGame) o;
        return player.equals(that.player) &&
                game.equals(that.game);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
