package com.cobbold.cedric.topquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
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
    private Question mCurrentQuestion;
    private int mNumberOfQuestions;
    private int mScore;
    private boolean mEnableTouchEvents;
    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
    public static final String BUNDLE_STATE_SCORE = "CURRENT_SCORE";
    public static final String BUNDLE_STATE_QUESTION = "CURRENT_QUESTION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("GameActivity :: onCreate()");

        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            mNumberOfQuestions = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
        } else {
            mScore = 0;
            mNumberOfQuestions = 4;
        }

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
        mNumberOfQuestions =4;
        mCurrentQuestion = mQuestionBank.getQuestion();
        displayQuestion(mCurrentQuestion);
        mGameAnswer1.setText(mCurrentQuestion.getChoiceList().get(0));
        mGameAnswer2.setText(mCurrentQuestion.getChoiceList().get(1));
        mGameAnswer3.setText(mCurrentQuestion.getChoiceList().get(2));
        mGameAnswer4.setText(mCurrentQuestion.getChoiceList().get(3));
        mScore = 0;

    }

    public void startActivity(Intent intent){

    }

    public void startActivityForResult(Intent intent, int requestCode){

    }

    public QuestionBank generateQuestion(){
        Question question1 = new Question("Combien d'oscars le film Titanic a-t-il obtenu?",
                Arrays.asList("10",
                        "11",
                        "12",
                        "13"),
                1);

        Question question2 = new Question("Combien de films Tomb Raider ont été réalisés?",
                Arrays.asList("1",
                        "2",
                        "3",
                        "4"),
                2);

        Question question3 = new Question("Qui a joué le rôle principal dans le film Scarface en 1983?",
                Arrays.asList("Al Pacino",
                        "Martin Scorcese",
                        "Denzell Washington",
                        "Robert De Niro"),
                0);


        Question question4 = new Question("Quel acteur a joué James Bond en 1990?",
                Arrays.asList("Anthony Hopkins",
                        "Daniel Craig",
                        "Pierre Brosnan",
                        "Jean Reno"),
                2);

        Question question5 = new Question("Quel est le plus gros légume?",
                Arrays.asList("Citrouille",
                        "Choux",
                        "Tomate",
                        "Melon"),
                0);

        Question question6 = new Question("D'où viennent les tomates?",
                Arrays.asList("Asie",
                        "Afrique",
                        "Amérique",
                        "Océanie"),
                2);

        Question question7 = new Question("Pendant combien d'années un président français est-il élu?",
                Arrays.asList("3 ans",
                        "5 ans",
                        "7 ans",
                        "8 ans"),
                1);

        Question question8 = new Question("Quelle est la langue la plus parlée en Belgique?",
                Arrays.asList("Néerlandais",
                        "Allemand",
                        "Français",
                        "Anglais"),
                0);

        Question question9 = new Question("Quel est le numéro de maison des Simpson?",
                Arrays.asList("42",
                        "101",
                        "666",
                        "742"),
                3);

        Question question10 = new Question("Dans quelle maison habite le président américain?",
                Arrays.asList("Maison ovale",
                        "Maison blanche",
                        "Maison dorée",
                        "Grande Maison"),
                1);

        Question question11 = new Question("Quel président américain apparaît sur un billet d'un dollar?",
                Arrays.asList("Abraham Lincoln",
                        "Bill Clinton",
                        "Theodore Roosevelt",
                        "George Washington"),
                3);

        Question question12 = new Question("Quelle est la langue officielle au Kosovo?",
                Arrays.asList("Anglais",
                        "Français",
                        "Albanais",
                        "Allemand"),
                2);

        Question question13 = new Question("Combien d'étoiles a le drapeau américain?",
                Arrays.asList("50",
                        "60",
                        "70",
                        "100"),
                0);

        Question question14 = new Question("Quel est le prénom de l'inventeur de Ferrari??",
                Arrays.asList("Enzo",
                        "Fabio",
                        "Franco",
                        "Fernando"),
                0);

        Question question15 = new Question("Sur quelle montagne Jésus a-t-il pris son dernier souper?",
                Arrays.asList("Sinaï",
                        "Golgotha",
                        "Bethléem",
                        "Nazareth"),
                1);

        Question question16 = new Question("Quelle est l'université la plus connue de Paris?",
                Arrays.asList("UPMC",
                        "HEC",
                        "Cergy Pontoise",
                        "Sorbonne"),
                3);

        Question question17 = new Question("Combien d'étoiles figurent sur le drapeau de la Nouvelle-Zélande?",
                Arrays.asList("3",
                        "4",
                        "6",
                        "7"),
                1);

        Question question18 = new Question("Qu'est-ce que les libellules préfèrent manger?",
                Arrays.asList("Mouches",
                        "Moucherons",
                        "Moustiques",
                        "Papillons"),
                2);

        Question question19 = new Question("En quelle année Google a-t-il été lancé sur le Web?",
                Arrays.asList("1998",
                        "1999",
                        "2000",
                        "2001"),
                0);

        Question question20 = new Question("En informatique, Ram signifie mémoire?",
                Arrays.asList("Rare",
                        "Rapide",
                        "Vive",
                        "Flash"),
                2);

        Question question21 = new Question("Quel pays a jadis porté le nom de Rhodésie?",
                Arrays.asList("Russie",
                        "Zimbabwe",
                        "Roumanie",
                        "Algérie"),
                1);

        Question question22 = new Question("Quel est le deuxième plus grand pays d'Europe après la Russie?",
                Arrays.asList("France",
                        "Allemagne",
                        "Grande-Bretagne",
                        "Espagne"),
                0);

        Question question23 = new Question("Sur quel continent pouvez-vous visiter la Sierra Leone?",
                Arrays.asList("Asie",
                        "Amérique",
                        "Antartique",
                        "Afrique"),
                2);

        Question question24 = new Question("Dans quel pays se trouve Cracovie?",
                Arrays.asList("Ukraine",
                        "Pologne",
                        "Danemark",
                        "Hollande"),
                1);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3, question4, question5, question6, question7, question8, question9, question10, question11, question12, question13, question14, question15 ));
    }

    private void displayQuestion(final Question question) {
        // Set the text for the question text view and the four buttons

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEnableTouchEvents = true;
                mQuestionText.setText(question.getQuestion());
                mGameAnswer1.setText(question.getChoiceList().get(0));
                mGameAnswer2.setText(question.getChoiceList().get(1));
                mGameAnswer3.setText(question.getChoiceList().get(2));
                mGameAnswer4.setText(question.getChoiceList().get(3));
            }
                // If this is the last question, ends the game.
                // Else, display the next question.
        }, 2000); // LENGTH_SHORT is usually 2 second long


    }

    @Override
    public void onClick(View view) {
        int responseIndex = (int) view.getTag();
        String textToShow="";

        if(mCurrentQuestion.getAnswerIndex() == responseIndex){
            textToShow = "Bonne réponse";
            mScore++;
        }
        else{
            textToShow = "Mauvaise Réponse";
        }
        Toast.makeText(this, textToShow, Toast.LENGTH_SHORT).show();
        mEnableTouchEvents = false;
        if (--mNumberOfQuestions == 0) {
            // No question left, end the game
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Fin de la partie!")
                    .setMessage("Vous avez obtenu un score de " + mScore)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                            setResult(RESULT_OK, intent);
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

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvents && super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("GameActivity :: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("GameActivity :: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("GameActivity :: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("GameActivity :: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("GameActivity :: onDestroy()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(BUNDLE_STATE_SCORE, mScore);
        outState.putInt(BUNDLE_STATE_QUESTION, mNumberOfQuestions);
        super.onSaveInstanceState(outState);
    }
}

