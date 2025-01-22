package com.example.koikoi;

import java.util.ArrayList;
import java.util.List;

public interface IFirebase {
    void uDataCallback(User user);
    void lobbyDataCallback(ArrayList<GameState> lobbies);
}
