package com.example.koikoi;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    ImageView iv_card1, iv_card2, iv_card3, iv_card4, iv_card5, iv_card6, iv_card7, iv_card8;
    ArrayList<Integer> cards;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        iv_card1 = findViewById(R.id.iV_card1);
        iv_card2 = findViewById(R.id.iV_card2);
        iv_card3 = findViewById(R.id.iV_card3);
        iv_card4 = findViewById(R.id.iV_card4);
        iv_card5 = findViewById(R.id.iV_card5);
        iv_card6 = findViewById(R.id.iV_card6);
        iv_card7 = findViewById(R.id.iV_card7);
        iv_card8 = findViewById(R.id.iV_card8);


    }
}
