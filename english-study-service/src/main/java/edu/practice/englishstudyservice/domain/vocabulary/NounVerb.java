package edu.practice.englishstudyservice.domain.vocabulary;

import javax.persistence.*;

@Entity
@Table(name = "noun_verbs")
public class NounVerb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nounVerb;
    private String nounTranslation;
    private String verbTranslation;

    public NounVerb() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNounVerb() {
        return nounVerb;
    }

    public void setNounVerb(String nounVerb) {
        this.nounVerb = nounVerb;
    }

    public String getNounTranslation() {
        return nounTranslation;
    }

    public void setNounTranslation(String nounTranslation) {
        this.nounTranslation = nounTranslation;
    }

    public String getVerbTranslation() {
        return verbTranslation;
    }

    public void setVerbTranslation(String verbTranslation) {
        this.verbTranslation = verbTranslation;
    }
}
