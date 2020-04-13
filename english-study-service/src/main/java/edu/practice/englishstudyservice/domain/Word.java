package edu.practice.englishstudyservice.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "words")
public class Word implements Serializable {
    @Id
    @Column(name = "word")
    private String word;
    private String translation;

    @OneToMany(mappedBy="word")
    private List<Example> examples;

    public Word(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public Word() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public List<Example> getExamples() {
        return examples;
    }

    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }

    @Override
    public String toString() {
        return word +
                " - " + translation +
                "\n examples:" + examples;
    }
}
