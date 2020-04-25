package edu.practice.programmingstudyservice.entities;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private Long questionId;
    private String questionText;
    private QuestionTopic topic;

    @OneToOne(mappedBy = "question")
    private Answer rightAnswer;

    public Question(String questionText, QuestionTopic topic) {
        this.questionText = questionText;
        this.topic = topic;
    }

    public Question() {
    }

    public Answer getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Answer rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestionTopic getTopic() {
        return topic;
    }

    public void setTopic(QuestionTopic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", topic=" + topic +
                '}';
    }
}
