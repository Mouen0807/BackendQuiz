package DTO;


public class QuestionDTO {


    private Long id;
    private String name;
    private DifficultyDTO difficulty;
    private CategoryDTO category;
    private String concatenedAnswers; // answers are concatened in on string separate by a --
    private int numberOfCorrectAnswer;

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


}
