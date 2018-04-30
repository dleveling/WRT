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

    public int[] imageArray = {R.drawable.ant,R.drawable.snake,R.drawable.spider,R.drawable.king,R.drawable.boat,R.drawable.bee,R.drawable.alligator
            ,R.drawable.bear,R.drawable.fish,R.drawable.monkey,R.drawable.cat,R.drawable.dog,R.drawable.octopus};

    private TextView WRDtv;
    private EditText WRDet;
    private Button checkbt,skipbt;
    private String wordToFind;
    private ImageView img;
    public String imgName = "";
    public String viewname = "";

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
        imgName = "R.drawable."+wordToFind;
        String wordShuffled = WRTs.shuffleword(wordToFind);
        WRDtv.setText(wordShuffled);
        WRDet.setText("");


        /*for (int i=0; i<imageArray.length; i++){

            img.setImageResource(imageArray[i]);
            img.setTag(imageArray[i]);
            viewname = String.valueOf(img.getTag());

            System.out.print(viewname);

            if( viewname.equals(wordToFind))
            {
                img.setImageResource(imageArray[i]);
            }

        }*/

        if (wordToFind == "monkey"){
            img.setImageResource(R.drawable.monkey);
        }else if(wordToFind == "ant"){
            img.setImageResource(R.drawable.ant);
        }else if(wordToFind == "snake"){
            img.setImageResource(R.drawable.snake);
        }else if(wordToFind == "spider"){
            img.setImageResource(R.drawable.spider);
        }else if(wordToFind == "king"){
            img.setImageResource(R.drawable.king);
        }else if(wordToFind == "boat"){
            img.setImageResource(R.drawable.boat);
        }else if(wordToFind == "bee"){
            img.setImageResource(R.drawable.bee);
        }else if(wordToFind == "alligator"){
            img.setImageResource(R.drawable.alligator);
        }else if(wordToFind == "bear"){
            img.setImageResource(R.drawable.bear);
        }else if(wordToFind == "fish"){
            img.setImageResource(R.drawable.fish);
        }else if(wordToFind == "cat"){
            img.setImageResource(R.drawable.cat);
        }else if(wordToFind == "dog"){
            img.setImageResource(R.drawable.dog);
        }else {
            img.setImageResource(R.drawable.octopus);
        }

    }

}
