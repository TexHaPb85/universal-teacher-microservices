package edu.practice.englishstudyservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "examples")
public class Example implements Serializable {
    @Id
    private String sentence;
    private String translation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "word_id")
    @JsonIgnore
    private Word word;

    public Example(String sentence, String translation, Word word) {
        this.sentence = sentence;
        this.translation = translation;
        this.word = word;
    }

    public Example() {
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }


    @Override
    public String toString() {
        return  "\n" + sentence  + " --> " +
                "\n" + translation;
    }
}
