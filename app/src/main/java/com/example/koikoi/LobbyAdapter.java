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

public class LobbyAdapter extends RecyclerView.Adapter<LobbyAdapter.LobbiesViewHolder> {
    private ArrayList<GameState> lobbies;

    public LobbyAdapter(ArrayList<GameState> lobbies) {
        this.lobbies = lobbies;
    }

    @NonNull
    @Override
    public LobbiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View lobbiesView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem_lobby, parent, false);
        return new LobbiesViewHolder(lobbiesView);
    }

    @Override
    public void onBindViewHolder(@NonNull LobbiesViewHolder holder, int position) {
        GameState currentGame = lobbies.get(position);
        holder.lobbyNameView.setText(currentGame.getlName());
        holder.lobbyDetailsView.setText(currentGame.getPlayerNames());
        holder.valBtn.setText(currentGame.getlID());
        if (!currentGame.isFull())
            holder.button.setText("Join");
        else
            holder.button.setText("spectate");
    }

    @Override
    public int getItemCount() {
        return lobbies.size();
    }

    public static class LobbiesViewHolder extends RecyclerView.ViewHolder {
        public TextView lobbyNameView, lobbyDetailsView;
        public Button button, valBtn;
        public LobbiesViewHolder(@NonNull View itemView) {
            super(itemView);
            lobbyNameView = itemView.findViewById(R.id.lobbyNameView);
            lobbyDetailsView = itemView.findViewById(R.id.lobbyDetailsView);
            button = itemView.findViewById(R.id.joinButton);
            valBtn = itemView.findViewById(R.id.hiddenvalbtn);
        }
    }
}