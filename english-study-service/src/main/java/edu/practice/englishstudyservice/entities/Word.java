package edu.practice.englishstudyservice.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "words")
public class Word implements Serializable {
    @Id
    private String word_id;
    private String word;
    private String translation;

    @OneToMany(mappedBy="word")
    private List<Example> examples;

    public Word(String word_id, String word, String translation) {
        this.word_id = word_id;
        this.word = word;
        this.translation = translation;
    }

    public Word() {
    }

    public String getWord_id() {
        return word_id;
    }

    public void setWord_id(String word_id) {
        this.word_id = word_id;
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
        return "Word{" +
                "word_id='" + word_id + '\'' +
                ", word='" + word + '\'' +
                ", translation='" + translation + '\'' +
                ", examples=" + examples +
                '}';
    }
}
