package edu.practice.programmingstudyservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long answerId;
    private String answerText;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quest_id", referencedColumnName = "question_id")
    @JsonIgnore
    private Question question;

    public Answer(String answerText, Question question) {
        this.answerText = answerText;
        this.question = question;
    }

    public Answer() {
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
