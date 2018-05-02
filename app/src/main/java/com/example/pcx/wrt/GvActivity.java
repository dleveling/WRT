package com.example.pcx.wrt;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GvActivity extends AppCompatActivity implements View.OnClickListener {

    public int[] imageArray = {R.drawable.ant,R.drawable.snake,R.drawable.spider,R.drawable.king,R.drawable.boat,R.drawable.bee,R.drawable.alligator
            ,R.drawable.bear,R.drawable.fish,R.drawable.monkey,R.drawable.cat,R.drawable.dog,R.drawable.octopus};

    private TextView SkipChance;
    private TextView Lid;
    private TextView Score ;
    private TextView WRDtv;
    private EditText WRDet;
    private Button checkbt,skipbt;
    private String wordToFind;
    private ImageView img;
    public String imgName = "";

    int sc = 0;
    int skipChance = 3;
    int lifeChance = 3;

    Dialog myDialog;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gv);
        myDialog = new Dialog(this);
        SkipChance = (TextView) findViewById(R.id.chancegame_id);
        Lid = (TextView) findViewById(R.id.Life_id);
        Score = (TextView) findViewById(R.id.scoregame_id);
        WRDtv = (TextView) findViewById(R.id.tv_wtf);
        WRDet = (EditText) findViewById(R.id.et_enter);
        checkbt = (Button) findViewById(R.id.bt_checkwrt);
        checkbt.setOnClickListener(this);
        skipbt = (Button) findViewById(R.id.bt_skipwrt);
        skipbt.setOnClickListener(this);
        img = (ImageView) findViewById(R.id.wrdimg);

        newGame();
    }

    @Override
    public void onClick(View v) {
        if(v == checkbt){
            CheckWrd();
        }else if (v == skipbt){
            if (skipChance <= 3 && skipChance > 0){
                skipChance = skipChance - 1;
                newGame();
            }else{
                ShowPopupSkip("\uD83D\uDE1C \n No Chance Left.");
            }

        }
    }

    private void CheckWrd(){
        String wrd = WRDet.getText().toString();
        if (wordToFind.equals(wrd)){
            ShowPopupSkip("\uD83D\uDE42 \n Score +1 !");
            ScoreUp();
            newGame();
        }else{
            ShowPopupSkip("☹️\n Retry !");

            if (lifeChance<= 3 && lifeChance > 0){
                lifeChance = lifeChance - 1;
                Lid.setText("❤ "+lifeChance);
            }else {
                ShowPopupGameOver();
            }

        }
    }

    private void newGame(){
        SkipChance.setText("Skip : "+(skipChance));
        Score.setText("Score : "+(sc));
        Lid.setText("❤ "+lifeChance);
        wordToFind = WRTs.randomWords();
        setImage(wordToFind);
        imgName = "R.drawable."+wordToFind;
        String wordShuffled = WRTs.shuffleword(wordToFind);
        WRDtv.setText(wordShuffled);
        WRDet.setText("");

    }

    private void setImage(String wordTF){

        if (wordTF == "monkey"){
            img.setImageResource(R.drawable.monkey);
        }else if(wordTF == "ant"){
            img.setImageResource(R.drawable.ant);
        }else if(wordTF == "snake"){
            img.setImageResource(R.drawable.snake);
        }else if(wordTF == "spider"){
            img.setImageResource(R.drawable.spider);
        }else if(wordTF == "king"){
            img.setImageResource(R.drawable.king);
        }else if(wordTF == "boat"){
            img.setImageResource(R.drawable.boat);
        }else if(wordTF == "bee"){
            img.setImageResource(R.drawable.bee);
        }else if(wordTF == "alligator"){
            img.setImageResource(R.drawable.alligator);
        }else if(wordTF == "bear"){
            img.setImageResource(R.drawable.bear);
        }else if(wordTF == "fish"){
            img.setImageResource(R.drawable.fish);
        }else if(wordTF == "cat"){
            img.setImageResource(R.drawable.cat);
        }else if(wordTF == "dog"){
            img.setImageResource(R.drawable.dog);
        }else {
            img.setImageResource(R.drawable.octopus);
        }
    }

    private void ScoreUp(){
        sc = sc+1;
    }

    public void ShowPopupSkip(String textQ){
        TextView txtclose,textto;
        Button btnOkay;

        myDialog.setContentView(R.layout.custompopup);
        txtclose = (TextView) myDialog.findViewById(R.id.xclose);
        textto = (TextView) myDialog.findViewById(R.id.textShowPopup01);
        btnOkay = (Button) myDialog.findViewById(R.id.bt_okread);

        textto.setText(textQ+"");

        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.show();
    }

    private void ShowPopupGameOver(){
        TextView txtPoint;
        Button resetButton;

        myDialog.setContentView(R.layout.gameoverpopup);
        txtPoint = (TextView) myDialog.findViewById(R.id.gameover_point_id);
        resetButton = (Button) myDialog.findViewById(R.id.bt_reset);

        txtPoint.setText(sc+"");

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipChance = 3;
                lifeChance = 3;
                sc = 0;
                newGame();
                myDialog.dismiss();
            }
        });

    }

}
