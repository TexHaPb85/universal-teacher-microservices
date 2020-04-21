package edu.practice.englishstudyservice.domain;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "irr_verb_id")
    @JsonIgnore
    private IrregularVerb irregularVerb;

    public Example(String sentence, String translation, Word word) {
        this.sentence = sentence;
        this.translation = translation;
        this.word = word;
    }

    public Example(String sentence, String translation, IrregularVerb irregularVerb) {
        this.sentence = sentence;
        this.translation = translation;
        this.irregularVerb = irregularVerb;
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
