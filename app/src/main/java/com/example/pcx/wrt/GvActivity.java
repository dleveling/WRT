package com.example.pcx.wrt;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GvActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView WRDtv;
    private EditText WRDet;
    private Button checkbt,skipbt;
    private String wordToFind;
    private ImageView img;
    public String imgName = "";

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gv);

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
            newGame();
        }
    }

    private void CheckWrd(){
        String wrd = WRDet.getText().toString();
        if (wordToFind.equals(wrd)){
            Toast.makeText(this,"Correct,Get 1 Point !!!" + wordToFind,Toast.LENGTH_SHORT).show();
            newGame();
        }else{
            Toast.makeText(this,"Retry !",Toast.LENGTH_SHORT).show();
        }
    }

    private void newGame(){
        wordToFind = WRTs.randomWords();
        imgName = wordToFind;
        String wordShuffled = WRTs.shuffleword(wordToFind);
        WRDtv.setText(wordShuffled);
        WRDet.setText("");
        img.setImageResource(R.drawable.snake);
    }

}
