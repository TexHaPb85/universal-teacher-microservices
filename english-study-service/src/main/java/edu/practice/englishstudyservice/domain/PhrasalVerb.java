package edu.practice.englishstudyservice.domain;

import javax.persistence.*;

@Entity
@Table(name = "phrasal_verbs")
public class PhrasalVerb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phrasalVerb;
    private String verb;
    private String translation;

    public PhrasalVerb() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhrasalVerb() {
        return phrasalVerb;
    }

    public void setPhrasalVerb(String phrasalVerb) {
        this.phrasalVerb = phrasalVerb;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
