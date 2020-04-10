package edu.practice.englishstudyservice;

import edu.practice.englishstudyservice.entities.Word;
import edu.practice.englishstudyservice.repos.WordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

//@SpringBootTest
class EnglishStudyServiceApplicationTests {

    @Autowired
    private WordRepository wordRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void saveTest(){
        Word word = new Word("word","слово");
        wordRepository.save(word);
        Assert.isTrue(wordRepository.findById("1").isPresent());
    }

}
