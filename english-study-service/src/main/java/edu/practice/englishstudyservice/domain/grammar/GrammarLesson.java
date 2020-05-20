package edu.practice.englishstudyservice.domain.grammar;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grammar_lessons")
public class GrammarLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lessonId;
    private String youTubeUrl;
    private String textDescription;
    private String topic;

    @OneToMany(mappedBy = "lesson")
    private List<GrammarTask> tasks;

    public GrammarLesson() {
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public String getYouTubeUrl() {
        return youTubeUrl;
    }

    public void setYouTubeUrl(String youTubeUrl) {
        this.youTubeUrl = youTubeUrl;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<GrammarTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<GrammarTask> tasks) {
        this.tasks = tasks;
    }
}
