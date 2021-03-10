package DTO;

import DTO.AnswerDTO;
import DTO.CategoryDTO;
import DTO.DifficultyDTO;
import DTO.GameDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;




public class QuestionDTO {


    private Long id;
    private String name;
    private DifficultyDTO difficulty;
    private CategoryDTO category;
    private List<AnswerDTO> answers= new ArrayList<AnswerDTO>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
