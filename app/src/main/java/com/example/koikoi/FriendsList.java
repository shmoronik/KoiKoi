package com.example.koikoi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FriendsList extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_friends);

        ArrayList<Friend> friends = new ArrayList<>();
        for(int i=1; i<15; i++){
            friends.add(new Friend(Integer.toString(i), (int)(Math.random()*100), (int)(Math.random()*100)));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerViewFriends);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
