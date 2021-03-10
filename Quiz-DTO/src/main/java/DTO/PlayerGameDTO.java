package DTO;

import DTO.GameDTO;
import DTO.PlayerDTO;
import lombok.Getter;
import lombok.Setter;



public class PlayerGameDTO {

    private Long id;
    private PlayerDTO player ;


    private GameDTO game ;
    private int Score;
    private int secondEffective;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }

    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
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
}
