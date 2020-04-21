package edu.practice.englishstudyservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class IrregularVerb {
    @Id
    private String infinitive;
    private String pastSimple;
    private String pastParticiple;
    private String translation;

    @OneToMany(mappedBy="irregularVerb")
    private List<Example> examples;

    public IrregularVerb(String infinitive, String pastSimple, String pastParticiple, String translation) {
        this.infinitive = infinitive;
        this.pastSimple = pastSimple;
        this.pastParticiple = pastParticiple;
        this.translation = translation;
    }

    public IrregularVerb() {
    }

    public String getInfinitive() {
        return infinitive;
    }

    public void setInfinitive(String infinitive) {
        this.infinitive = infinitive;
    }

    public String getPastSimple() {
        return pastSimple;
    }

    public void setPastSimple(String pastSimple) {
        this.pastSimple = pastSimple;
    }

    public String getPastParticiple() {
        return pastParticiple;
    }

    public void setPastParticiple(String pastParticiple) {
        this.pastParticiple = pastParticiple;
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
        return "IrregularVerb{" +
                "infinitive='" + infinitive + '\'' +
                ", pastSimple='" + pastSimple + '\'' +
                ", pastParticiple='" + pastParticiple + '\'' +
                ", translation='" + translation + '\'' +
                ", examples=" + examples +
                '}';
    }
}
