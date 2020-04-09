package edu.practice.englishstudyservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "words")
public class Word {
    @Id
    private String id;
    private String word;
    private String translation;

    private List<String> examples;

    public Word(String id, String word, String translation, List<String> examples) {
        this.id = id;
        this.word = word;
        this.translation = translation;
        this.examples = examples;
    }

    public Word() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getExamples() {
        return examples;
    }

    public void setExamples(List<String> examples) {
        this.examples = examples;
    }
}
