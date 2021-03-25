package com.cobbold.cedric.topquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cobbold.cedric.topquiz.model.Question;
import com.cobbold.cedric.topquiz.model.QuestionBank;
import com.cobbold.cedric.topquiz.model.User;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private User mUser;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    private SharedPreferences preferences;
    private TextView mRememberText;
    private String mFirstnameRemember;
    private int  mScoreRemember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("MainActivity :: onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUser = new User();
        mGreetingText = (TextView) findViewById(R.id.activity_main_greeting_txt);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);
        mRememberText = (TextView) findViewById(R.id.activity_main_remember_txt);
        mPlayButton.setEnabled(false);
        preferences = getPreferences(MODE_PRIVATE);
        mFirstnameRemember = getPreferences(MODE_PRIVATE).getString("firstname", null);
        mScoreRemember = getPreferences(MODE_PRIVATE).getInt("score", -1);
        if(null == mFirstnameRemember && mScoreRemember == -1){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("firstname", mUser.getFirstName());
            editor.apply();
        }
        else{
            String textToDisplay = "Bon retour "+mFirstnameRemember+" !\nTon dernier score était "+(mScoreRemember)+", feras-tu mieux cette fois ?";
            mRememberText.setText(textToDisplay);
            mNameInput.setText(mFirstnameRemember);
            mNameInput.setSelection(mNameInput.getText().length());
            mPlayButton.setEnabled(true);
        }
        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length()!=0);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);
                startActivityForResult(gameActivity, GAME_ACTIVITY_REQUEST_CODE);
                mUser.setFirstName(mNameInput.getText().toString());
                if(null == mFirstnameRemember && mScoreRemember == -1){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("firstname", mUser.getFirstName());
                    editor.apply();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            // Fetch the score from the Intent
            int score = data != null ? data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0) : -1;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score", score);
            editor.apply();
        }
    }

    public void startActivity(Intent intent){


    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("MainActivity :: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActivity :: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("MainActivity :: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("MainActivity :: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("MainActivity :: onDestroy()");
    }
}
