package com.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private int id;

    @Column(name = "o_text")
    private String text;

    @Column(name = "o_is_correct")
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "o_q_id")
    private Question question;

    // Constructors
    public Options() {}

    public Options(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public boolean isCorrect() { return correct; }
    public void setCorrect(boolean correct) { this.correct = correct; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }

    @Override
    public String toString() {
        return "Options{id=" + id + ", text='" + text + "', correct=" + correct + "}";
    }
}
