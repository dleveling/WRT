package com.example.pcx.wrt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button btnewgame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnewgame = (Button)findViewById(R.id.bt_newgame);
        btnewgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGV();
            }
        });

    }

    public void openGV(){
        Intent intent = new Intent(this,GvActivity.class);
        startActivity(intent);
    }

}
