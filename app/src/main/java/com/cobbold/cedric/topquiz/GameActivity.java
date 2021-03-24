package com.cobbold.cedric.topquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cobbold.cedric.topquiz.model.Question;
import com.cobbold.cedric.topquiz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mQuestionText;
    private Button mGameAnswer1;
    private Button mGameAnswer2;
    private Button mGameAnswer3;
    private Button mGameAnswer4;
    private QuestionBank mQuestionBank;
    private int mNumberOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mQuestionText = (TextView) findViewById(R.id.activity_game_question_text);
        mGameAnswer1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mGameAnswer2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mGameAnswer3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mGameAnswer4 = (Button) findViewById(R.id.activity_game_answer4_btn);
        // Use the same listener for the four buttons.
// The tag value will be used to distinguish the button triggered
        mGameAnswer1.setOnClickListener(this);
        mGameAnswer2.setOnClickListener(this);
        mGameAnswer3.setOnClickListener(this);
        mGameAnswer4.setOnClickListener(this);

        // Use the tag property to 'name' the buttons
        mGameAnswer1.setTag(0);
        mGameAnswer2.setTag(1);
        mGameAnswer3.setTag(2);
        mGameAnswer4.setTag(3);

        mQuestionBank = this.generateQuestion();
        mNumberOfQuestions = 2;
        Question quest = mQuestionBank.getQuestion();
        displayQuestion(quest);
        mGameAnswer1.setText(quest.getChoiceList().get(0));
        mGameAnswer2.setText(quest.getChoiceList().get(1));
        mGameAnswer3.setText(quest.getChoiceList().get(2));
        mGameAnswer4.setText(quest.getChoiceList().get(3));

    }

    public void startActivity(Intent intent){

    }

    public QuestionBank generateQuestion(){
        Question question1 = new Question("Who is the creator of Android?",
                Arrays.asList("Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"),
                0);

        Question question2 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958",
                        "1962",
                        "1967",
                        "1969"),
                3);

        Question question3 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42",
                        "101",
                        "666",
                        "742"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3));
    }

    private void displayQuestion(final Question question) {
        // Set the text for the question text view and the four buttons
        mQuestionText.setText(question.getQuestion());
        mGameAnswer1.setText(question.getChoiceList().get(0));
        mGameAnswer2.setText(question.getChoiceList().get(1));
        mGameAnswer3.setText(question.getChoiceList().get(2));
        mGameAnswer4.setText(question.getChoiceList().get(3));
    }

    @Override
    public void onClick(View view) {
        int responseIndex = (int) view.getTag();
        String textToShow="";
        int mScore = 0;
        Question mCurrentQuestion = mQuestionBank.getQuestion();
        if(mCurrentQuestion.getAnswerIndex() == responseIndex){
            textToShow = "Correct";
            mScore++;
        }
        else{
            textToShow = "Erreur";
        }
        Toast.makeText(this, textToShow, Toast.LENGTH_SHORT).show();
        if (--mNumberOfQuestions == 0) {
            // No question left, end the game
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Well done!")
                    .setMessage("Your score is " + mScore)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .create()
                    .show();
        } else {
            mCurrentQuestion = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }
    }
}