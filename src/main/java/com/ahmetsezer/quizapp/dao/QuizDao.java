package com.ahmetsezer.quizapp.dao;

import com.ahmetsezer.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository <Quiz,Integer> {
}
