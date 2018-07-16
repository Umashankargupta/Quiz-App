package com.sonukumar.brainchallangequizapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HighScoreBoard extends AppCompatActivity {
    ListView listView;
    ArrayList<String>arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_board);
        listView=findViewById(R.id.list);
        ScoreDataBase scoreDataBase= new ScoreDataBase(HighScoreBoard.this);
        Cursor cursor = scoreDataBase.getData();
        arrayList = new ArrayList<>();
        if (cursor.moveToFirst())
        {
            do {
                String correct_answer=cursor.getString(cursor.getColumnIndex("Correct_Answer"));
                String incorrect_answer=cursor.getString(cursor.getColumnIndex("Incorrect_Answer"));
                String score=cursor.getString(cursor.getColumnIndex("Score"));
                String percentage=cursor.getString(cursor.getColumnIndex("Percentage"));
                String total_question_answered=cursor.getString(cursor.getColumnIndex("Total_Question_Answered"));

                String finalValue = correct_answer + " " + incorrect_answer + " " + score + " "+percentage+" "+ total_question_answered;

                Log.d("test",finalValue);

                arrayList.add(finalValue);
            }
            while (cursor.moveToNext());
        }
        arrayAdapter = new ArrayAdapter<>(HighScoreBoard.this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);



    }
}



