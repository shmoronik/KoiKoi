package com.example.koikoi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity implements IFirebase {
    FirebaseConnector fCon;
    TextView unameView, umailView, gamesView, winsView, lossView;
    //SharedPreferences sharedPreferences = getSharedPreferences("GenPrefs", MODE_PRIVATE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        fCon = new FirebaseConnector();
        fCon.readUData(this);
        // text views initialization
        unameView = findViewById(R.id.unameView);
        umailView = findViewById(R.id.umailView);
        gamesView = findViewById(R.id.gamesView);
        winsView = findViewById(R.id.winsView);
        lossView = findViewById(R.id.lossView);
    }

    public void returnMain(View view) {
        Intent i;
        i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void logout(View view) {
        fCon.logout(this);
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void uDataCallback(User user) {
        unameView.setText(user.getuName());
        umailView.setText(user.getEmail());
        gamesView.setText(String.valueOf(user.getGplayed()));
        winsView.setText(String.valueOf(user.getGwins()));
        lossView.setText(String.valueOf(user.getGlost()));

        RecyclerView recyclerView = this.findViewById(R.id.RecyclerViewFriends);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        FriendsAdapter friendsAdapter = new FriendsAdapter(user.getFriends());
        recyclerView.setAdapter(friendsAdapter);
    }

    @Override
    public void lobbyDataCallback(ArrayList<GameState> lobbies) {
    }
}
