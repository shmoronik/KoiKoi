package com.example.koikoi;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity implements IGame {

    VectorSwitch vs;
    LinearLayout ph;
    float WeightSum;
    ImageView[] pHCards, eHCards;
    ImageView[][] tCards;
    FirebaseConnector fCon; String key; String uid;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        WeightSum = 8f;
        fCon = new FirebaseConnector();
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
        key = getIntent().getStringExtra("key");
        uid = getIntent().getStringExtra("user");
        fCon.readGameState(this, key);
    }

    public void pCard(View view) {
        ph = (LinearLayout) findViewById(R.id.pHand);
        view.setVisibility(View.GONE);
        ph.setWeightSum(--WeightSum);
    }

    @Override
    public void GDataCallback(GameState GS) {
        int usermode = 0;
        if (GS.isP1(uid))
            usermode = 1;
        else if (GS.isP2(uid))
            usermode = 2;
        vs = new VectorSwitch();
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 8; i++) {
                switch (j) {
                    case 0:
                        switch (usermode) {
                            case 0:
                            case 1:
                                vs.customVector(pHCards[i], GS.getPlayer1_hand().getImg(i));
                            case 2:
                                vs.customVector(pHCards[i], GS.getPlayer2_hand().getImg(i));
                        }
                    case 1:
                        if (usermode==0)
                            vs.customVector(eHCards[i], GS.getPlayer1_hand().getImg(i));
                    case 2:
                        if(i<4)
                            vs.customVector(tCards[0][i], GS.getTable().getImg(i));
                        else
                            vs.customVector(tCards[1][i-4], GS.getTable().getImg(i));
                }
            }
        }
    }
}
