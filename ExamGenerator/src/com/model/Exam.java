package com.model;

import java.io.Serializable;
import java.util.HashMap;


public class Exam implements Serializable {

    private Question[] questions;
    private HashMap<Question, String> questionAnswer;
    private Student student;
    private int nextQuestion = -1;

    public Student getStudent() {
        return student;
    }

    public Exam(Student aStudent, Question[] ques) {
        this.student = aStudent;
        this.questionAnswer = new HashMap();
        this.questions = ques;
    }

    public int getScore() {
        int total = 0;
        for (Question q : this.questionAnswer.keySet()) {
            String answer = this.questionAnswer.get(q);
            if (q.isAnswerEqualTo(answer)) {
                total++;
            }
        }
        return total;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void answerQuestion(Question q, String ans) {
        this.questionAnswer.put(q, ans);
    }

    public Question nextQuestion() {
        this.nextQuestion++;
        if (this.nextQuestion < this.questions.length) {
            return this.questions[this.nextQuestion];
        } else {
            return null;
        }
    }
}

