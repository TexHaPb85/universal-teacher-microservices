package edu.practice.englishstudyservice.domain.grammar;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "grammar_tasks")
public class GrammarTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    private String question;
    private String answer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="less_id", nullable=false)
    private GrammarLesson lesson;

    public GrammarTask() {
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public GrammarLesson getLesson() {
        return lesson;
    }

    public void setLesson(GrammarLesson lesson) {
        this.lesson = lesson;
    }
}
