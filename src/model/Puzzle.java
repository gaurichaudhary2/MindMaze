package model;

public class Puzzle {

    private int id;
    private String category;
    private String question;
    private String[] options;
    private int correctAnswer;
    private int difficulty;

    public Puzzle(int id, String category, String question,
                  String[] options, int correctAnswer, int difficulty) {

        this.id = id;
        this.category = category;
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }
}