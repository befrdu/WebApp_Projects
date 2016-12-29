package com.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question implements Serializable {

    private final String question;
    private final String[] choices;
    private final String answer;

    public Question(String q, String[] cs, int anwerIndex) {
        this.question = q;
        this.choices = cs;
        this.answer = this.choices[anwerIndex];
    }

    public boolean isAnswerEqualTo(String ans) {
        return this.answer.equals(ans);
    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoices() {
        return choices;
    }

    public static Question[] getSampleQuestions() {
        Question[] questions = new Question[5];
        questions[0] = new Question(
                "Which of the following is true about servlets?",
                new String[]{"Servlets excute within the web server", "Servlets are platform-independent", "Can access java class libraries", "All"}, 3);
        questions[1] = new Question(
                "Which of the following is the correct order of servlet life cycle phase methods?",
                new String[]{"int(), service(), destroy() ", "service(), int(), destroy() ", "initialize(), servic(), destroy(), ", "init(), service(), delete()"}, 0);
        questions[2] = new Question(
                "When the init() method of servelet gets called?",
                new String[]{"When the servlet is first created.", "When the servlet is invoked","Both","None"}, 0);
        questions[3] = new Question(
                "Which of the following code is used to get PrintWriter object in servlet?",
                new String[]{"request.getWriter()", "response.getWriter()", "new printWriter()", "None"}, 1);
        questions[4] = new Question(
                "What happnes When i call getSession(false)? ",
                new String[]{"New session will always be created", "Will never create new session", "Retrieve the session or create new one", "None"}, 1);
        List<Question> list = Arrays.asList(questions);
        Collections.shuffle(Arrays.asList(questions));
        return (Question[])list.toArray();
    }
}
