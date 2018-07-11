package com.sonukumar.brainchallangequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name;
    TextView msg;
    Button start;
    String temp=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editText);
        msg=findViewById(R.id.textView);
        start=findViewById(R.id.button);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=name.getText().toString();
                if (temp.isEmpty())

                    msg.setText("You can't leve this empty !");

                else{
                    Intent game=new Intent(MainActivity.this,Main2Activity.class);
//                    EditText player_string=findViewById(R.id.editText);

//                    game.putExtra("Player_Name",String.valueOf(player_string.getText()));
                    startActivity(game);
                    MainActivity.this.finish();

            }
        }

    });
    }
}