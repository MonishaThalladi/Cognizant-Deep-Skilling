package com.library.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "q_id")
    private int id;

    @Column(name = "q_text")
    private String text;

    @Column(name = "q_score")
    private double score;

    @OneToMany(mappedBy = "question")
    private Set<Options> options;

    // Constructors
    public Question() {}

    public Question(String text, double score) {
        this.text = text;
        this.score = score;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public Set<Options> getOptions() { return options; }
    public void setOptions(Set<Options> options) { this.options = options; }

    @Override
    public String toString() {
        return "Question{id=" + id + ", text='" + text + "', score=" + score + "}";
    }
}
