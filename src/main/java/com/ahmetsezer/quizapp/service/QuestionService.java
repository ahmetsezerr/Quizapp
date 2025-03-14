package com.ahmetsezer.quizapp.service;

import com.ahmetsezer.quizapp.model.Question;
import com.ahmetsezer.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity <List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>( questionDao.findAll(), HttpStatus.OK);
            //  List<Question> questions = questionDao.findAll(); ya da böyle de diyebilirsin aşağıdaki yerine

        }catch (Exception e){
           e.printStackTrace();
        }
        return new ResponseEntity<>( new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity <List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>( questionDao.findByCategory(category), HttpStatus.OK);
            //  List<Question> questions = questionDao.findAll(); ya da böyle de diyebilirsin aşağıdaki yerine

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }



}
