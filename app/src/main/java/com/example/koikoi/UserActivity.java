package com.example.koikoi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class UserActivity extends AppCompatActivity implements IFirebase {
    FirebaseConnector fCon; EncodeBitmap bEncode;
    TextView unameView, umailView, gamesView, winsView, lossView;
    Button imageSet;
    ImageView pfp;
    private ActivityResultLauncher<Intent> imageActivityResultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        fCon = new FirebaseConnector();
        bEncode = new EncodeBitmap();
        fCon.readUData(this);
        imageActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if(o.getResultCode() == UserActivity.RESULT_OK && o.getData() != null && o.getData().getData() != null) {
                    Intent data = o.getData();
                    try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    fCon.uploadImage(bEncode.convertTo64Base(bitmap));}
                    catch (IOException e) {
                    e.printStackTrace();}
                }
            }
        });
        // text views initialization
        unameView = findViewById(R.id.unameView);
        umailView = findViewById(R.id.umailView);
        gamesView = findViewById(R.id.gamesView);
        winsView = findViewById(R.id.winsView);
        lossView = findViewById(R.id.lossView);
        imageSet = (Button) findViewById(R.id.imageSet);
        pfp = findViewById(R.id.imageView);
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

    public void setPfp(View view) {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        imageActivityResultLauncher.launch(i);
    }

    @Override
    public void uDataCallback(User user) {
        unameView.setText(user.getuName());
        umailView.setText(user.getEmail());
        gamesView.setText(String.valueOf(user.getGplayed()));
        winsView.setText(String.valueOf(user.getGwins()));
        lossView.setText(String.valueOf(user.getGlost()));
        pfp.setImageBitmap(bEncode.convertfrom64Base(user.getPfp()));

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
