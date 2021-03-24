package com.cobbold.cedric.topquiz.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuestionBank {

    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        // Shuffle the question list before storing it
        Collections.shuffle(questionList);
        mQuestionList = questionList;
    }

    public Question getQuestion() {
        Random rand = new Random();
        return mQuestionList.get(rand.nextInt(mQuestionList.size()));
        // Loop over the questions and return a new one at each call
    }

    public List<Question> getQuestionList() {
        return mQuestionList;
    }

    public void setQuestionList(List<Question> questionList) {
        mQuestionList = questionList;
    }

    public int getNextQuestionIndex() {
        return mNextQuestionIndex;
    }

    public void setNextQuestionIndex(int nextQuestionIndex) {
        mNextQuestionIndex = nextQuestionIndex;
    }
}
