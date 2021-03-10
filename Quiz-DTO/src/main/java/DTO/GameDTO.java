package DTO;



import java.util.ArrayList;

import java.util.Date;
import java.util.List;




public class GameDTO {

    private Long id;
    private Date date;

    private DifficultyDTO difficulty;

    private CategoryDTO category;

    private List<QuestionDTO> questions=new ArrayList<QuestionDTO>();

    /*private List<PlayerGameDTO> player_games=new ArrayList<PlayerGameDTO>();*/

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

    public DifficultyDTO getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyDTO difficulty) {
        this.difficulty = difficulty;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    /*public List<PlayerGameDTO> getPlayer_games() {
        return player_games;
    }

    public void setPlayer_games(List<PlayerGameDTO> player_games) {
        this.player_games = player_games;
    }*/
}
