package com.example.koikoi;

import android.app.ActionBar;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    LinearLayout ph;
    float i;
    Deck deck, pHand, eHand, table;
    ArrayList<ImageView> pHCards, eHCards, dCards;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        i=8f;
        // cards image view setup
        pHCards = new ArrayList<ImageView>();
        pHCards.add(findViewById(R.id.iV_pHCard1));
        pHCards.add(findViewById(R.id.iV_pHCard2));
        pHCards.add(findViewById(R.id.iV_pHCard3));
        pHCards.add(findViewById(R.id.iV_pHCard4));
        pHCards.add(findViewById(R.id.iV_pHCard5));
        pHCards.add(findViewById(R.id.iV_pHCard6));
        pHCards.add(findViewById(R.id.iV_pHCard7));
        pHCards.add(findViewById(R.id.iV_pHCard8));
        eHCards = new ArrayList<ImageView>();
        eHCards.add(findViewById(R.id.iV_eHCard1));
        eHCards.add(findViewById(R.id.iV_eHCard2));
        eHCards.add(findViewById(R.id.iV_eHCard3));
        eHCards.add(findViewById(R.id.iV_eHCard4));
        eHCards.add(findViewById(R.id.iV_eHCard5));
        eHCards.add(findViewById(R.id.iV_eHCard6));
        eHCards.add(findViewById(R.id.iV_eHCard7));
        eHCards.add(findViewById(R.id.iV_eHCard8));
        // cards setup
        deck = new Deck();
        pHand = new Deck(deck);
        eHand = new Deck(deck);
        table = new Deck(deck);
        // hand images setup
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 8; i++) {
                switch (j) {
                    case 0:
                        pHCards.get(i).setImageDrawable(getDrawable(pHand.getImg(i)));
                    case 1:
                        eHCards.get(i).setImageDrawable(getDrawable(eHand.getImg(i)));
                }
            }
        }
    }

    public void pCard(View view) {
        ph = (LinearLayout) findViewById(R.id.pHand);
        view.setVisibility(View.GONE);
        ph.setWeightSum(--i);
    }

}
