package edu.practice.englishstudyservice.domain.serving;

import java.util.List;

public class Action {
    private List<String> markedWords;
    private String action;

    public Action() {
    }

    public List<String> getMarkedWords() {
        return markedWords;
    }

    public void setMarkedWords(List<String> markedWords) {
        this.markedWords = markedWords;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Action{" +
                "markedWords=" + markedWords +
                ", action='" + action + '\'' +
                '}';
    }
}
