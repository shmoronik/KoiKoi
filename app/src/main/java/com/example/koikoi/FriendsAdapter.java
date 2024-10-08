package com.example.koikoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder> {
    private ArrayList<Friend> friends;

    public FriendsAdapter(ArrayList<Friend> friends) {
        this.friends = friends;
    }

    @NonNull
    @Override
    public FriendsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View friendsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem_friends, parent, false);
        return new FriendsViewHolder(friendsView);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsViewHolder holder, int position) {
        Friend currentFriend = friends.get(position);
        holder.usernameView.setText(currentFriend.getUname());
        holder.ratioView.setText(currentFriend.getWin()+" / "+currentFriend.getLoss());
        holder.button.setText("invite");
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public static class FriendsViewHolder extends RecyclerView.ViewHolder {
        public TextView usernameView;
        public TextView ratioView;
        public Button button;
        public FriendsViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameView = itemView.findViewById(R.id.usernameView);
            ratioView = itemView.findViewById(R.id.ratioView);
            button = itemView.findViewById(R.id.button);
        }
    }
}
