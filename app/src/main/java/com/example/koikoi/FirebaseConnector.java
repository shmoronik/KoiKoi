package com.example.koikoi;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseConnector {
    private static FirebaseAuth dAuth;
    private static FirebaseDatabase dBase;
    private static DatabaseReference dRef;

    public static FirebaseAuth getdAuth(){
        if (dAuth == null)
            dAuth = FirebaseAuth.getInstance();
        return dAuth;
    }

    public static FirebaseDatabase getdBase() {
        if(dBase == null) {
            dBase = FirebaseDatabase.getInstance("https://koikoi-4d98d-default-rtdb.firebaseio.com");
        }
        return dBase;
    }

    public static DatabaseReference getReference(String ref) {
        dRef = getdBase().getReference(ref);
        return dRef;
    }

    // user functions
    public void login(String email, String pass, Context context) {
        getdAuth().signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(context, "logged in", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(context, "email or password are incorrect", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void delete() {}
    public boolean isUser() {
        return getdAuth().getCurrentUser() != null;
    }
    public void uploadImage(String s) {
        getReference("users").child(getdAuth().getCurrentUser().getUid()).child("pfp").setValue(s);
    }
    public void logout(Context context) {
        getdAuth().signOut();
        Toast.makeText(context, "logout successful", Toast.LENGTH_LONG).show();
    }
    public void register(String pass, User user, Context context) {
        getdAuth().createUserWithEmailAndPassword(user.getEmail(), pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    user.setuId(getdAuth().getCurrentUser().getUid());
                    getReference("users").child(user.getuId()).setValue(user);
                    Toast.makeText(context, "user created successfully", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(context, "Error, " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    public void readUData(IFirebase fCallback) {
        if (getdAuth().getCurrentUser() == null) {
            User user = new User();
            fCallback.uDataCallback(user);
        }
        else
            getReference("users").child(getdAuth().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    User user = snapshot.getValue(User.class);
                    fCallback.uDataCallback(user);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
    }

    // game lobby functions
    public void createLobby(GameState GS, Context context) {
        getReference("games").child(GS.getlID()).setValue(GS);
        Toast.makeText(context, "lobby created", Toast.LENGTH_SHORT).show();
    }

    public void joinLobby(String uName, String id) {
        getReference("games").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!snapshot.hasChild("player2"))
                    getReference("games").child(id).child("player2").setValue(uName);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void readGameState(IGame fCallback, String key) {
        getReference("games").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GameState GS = snapshot.getValue(GameState.class);
                fCallback.GDataCallback(GS);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void roundStart(GameState GS) {
        getReference("games").child(GS.getlID()).child("deck").setValue(GS.getDeck());
        getReference("games").child(GS.getlID()).child("pHand").setValue(GS.getPlayer1_hand());
        getReference("games").child(GS.getlID()).child("eHand").setValue(GS.getPlayer2_hand());
        getReference("games").child(GS.getlID()).child("table").setValue(GS.getTable());
        getReference("games").child(GS.getlID()).child("round").setValue(GS.getRound());
    }

    public void readLobbies(IFirebase fCallback) {
        getReference("games").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<GameState> lobbies = new ArrayList<GameState>();
                for(DataSnapshot lobbySnapshot : snapshot.getChildren()) {
                    lobbies.add(lobbySnapshot.getValue(GameState.class));
                }
                fCallback.lobbyDataCallback(lobbies);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
