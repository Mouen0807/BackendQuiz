package Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Difficulty difficulty;
    @ManyToOne
    private Category category;
    private String concatenedAnswers; // answers are concatened in on string separate by a --
    private int numberOfCorrectAnswer;

    public String getConcatenedAnswers() {
        return concatenedAnswers;
    }

    public void setConcatenedAnswers(String concatenedAnswers) {
        this.concatenedAnswers = concatenedAnswers;
    }

    public int getNumberOfCorrectAnswer() {
        return numberOfCorrectAnswer;
    }

    public void setNumberOfCorrectAnswer(int numberOfCorrectAnswer) {
        this.numberOfCorrectAnswer = numberOfCorrectAnswer;
    }

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

}
