package Entities;

import javax.persistence.*;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
//import java.util.Objects;

@Entity

public class Game {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Date date;
    @ManyToOne
    private Difficulty difficulty;
    @ManyToOne
    private Category category;
    @OneToMany
    private List<Question> questions=new ArrayList<Question>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    /*
    public List<PlayerGame> getPlayer_games() {
        return player_games;
    }

    public void setPlayer_games(List<PlayerGame> player_games) {
        this.player_games = player_games;
    }*/


}
