package com.example.koikoi;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    LinearLayout ph;
    float WeightSum;
    int marginSize, pMarginSize;
    Deck deck, pHand, eHand, table;
    View sCard;
    ImageView[] pHCards, eHCards;
    ImageView[][] tCards;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        WeightSum =8f; marginSize = pxConverter(2); pMarginSize = pxConverter(1);
        // cards image view setup
        pHCards = new ImageView[8];
        pHCards[0] = (findViewById(R.id.iV_pHCard1));
        pHCards[1] = (findViewById(R.id.iV_pHCard2));
        pHCards[2] = (findViewById(R.id.iV_pHCard3));
        pHCards[3] = (findViewById(R.id.iV_pHCard4));
        pHCards[4] = (findViewById(R.id.iV_pHCard5));
        pHCards[5] = (findViewById(R.id.iV_pHCard6));
        pHCards[6] = (findViewById(R.id.iV_pHCard7));
        pHCards[7] = (findViewById(R.id.iV_pHCard8));
        eHCards = new ImageView[8];
        eHCards[0] = (findViewById(R.id.iV_eHCard1));
        eHCards[1] = (findViewById(R.id.iV_eHCard2));
        eHCards[2] = (findViewById(R.id.iV_eHCard3));
        eHCards[3] = (findViewById(R.id.iV_eHCard4));
        eHCards[4] = (findViewById(R.id.iV_eHCard5));
        eHCards[5] = (findViewById(R.id.iV_eHCard6));
        eHCards[6] = (findViewById(R.id.iV_eHCard7));
        eHCards[7] = (findViewById(R.id.iV_eHCard8));
        tCards = new ImageView[2][6];
        tCards[0][0] = (findViewById(R.id.iV_table1_1));
        tCards[0][1] = (findViewById(R.id.iV_table1_2));
        tCards[0][2] = (findViewById(R.id.iV_table1_3));
        tCards[0][3] = (findViewById(R.id.iV_table1_4));
        tCards[0][4] = (findViewById(R.id.iV_table1_5));
        tCards[0][5] = (findViewById(R.id.iV_table1_6));
        tCards[1][0] = (findViewById(R.id.iV_table2_1));
        tCards[1][1] = (findViewById(R.id.iV_table2_2));
        tCards[1][2] = (findViewById(R.id.iV_table2_3));
        tCards[1][3] = (findViewById(R.id.iV_table2_4));
        tCards[1][4] = (findViewById(R.id.iV_table2_5));
        tCards[1][5] = (findViewById(R.id.iV_table2_6));
        // cards setup
        deck = new Deck();
        pHand = new Deck(deck);
        eHand = new Deck(deck);
        table = new Deck(deck);
        sCard = pHCards[0];
        // hand images setup
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 8; i++) {
                switch (j) {
                    case 0:
                        pHCards[i].setImageDrawable(getDrawable(pHand.getImg(i)));
                    case 1:
                        eHCards[i].setImageDrawable(getDrawable(eHand.getImg(i)));
                    case 2:
                        if(i<4)
                            tCards[0][i].setImageDrawable(getDrawable(table.getImg(i)));
                        else
                            tCards[1][i-4].setImageDrawable(getDrawable(table.getImg(i)));
                }
            }
        }
    }

    public void selectCard(View view) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        params.setMargins(marginSize,marginSize,marginSize,marginSize);
        sCard.setLayoutParams(params);
        params.setMargins(pMarginSize,pMarginSize,pMarginSize,pMarginSize);
        view.setLayoutParams(params);
        sCard = view;
    }

    public void pCard(View view) {
        ph = (LinearLayout) findViewById(R.id.pHand);
        view.setVisibility(View.GONE);
        ph.setWeightSum(--WeightSum);

    }

    public int pxConverter(int DP) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DP, getResources().getDisplayMetrics());
    }
}
