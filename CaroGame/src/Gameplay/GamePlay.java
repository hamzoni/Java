package Gameplay;

import Compute.*;
import Entities.Caro;
import Networking.Client;
import Networking.Credential;
import Networking.Server;
import Networking.ServerListOUT;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GamePlay {
    public static final int PVE = 0;
    public static final int PVP = 1;
    public static final int DEMO = -1;
    
    public Frame window;
    public ServerListOUT serverlist;
    public Server server;
    public Client client;
    public boolean hostGame;
    
    public HashMap<String, GameThread> games;

    public static void main(String[] args) {
        new GamePlay().init();
    }

    public void init() {
        games = new HashMap<String, GameThread>();
        hostGame = false;
        window = new Frame(this);
        window.setVisible(true);
        window.frame_c.show_layer(0);
    }
    public void create_demo() {
        GameThread newGame = new GameThread(DEMO, 0, this);
        Caro map = new Caro();
        newGame.map = map;
        new Thread(newGame).start();
    }
    public void create_game(int type, int turn, Caro map) {
        GameThread newGame = new GameThread(type, turn, this);
        newGame.map = map;
        games.put(map.getGameID(), newGame);
        new Thread(newGame).start();
    }
    public void create_AI_game(int turn, int difficulty) {
        Caro map = new Caro();
        int pID = (int) new Date().getTime();
        String gameID = "0_" + (turn == 0 ?  pID + "_0" :  "0_" + pID)  + "_" + new Date().getTime();
        map.setGameID(gameID);

        AIControl.DEPTH = difficulty;
        create_game(0, turn, map);
    }
    public void end_game() {
        Iterator it = games.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String gameID = (String) pair.getKey();
            GameThread game = (GameThread) pair.getValue();
            // ANALYZE GAME ID
            String[] compID = gameID.split("_");
            int param1 = Integer.parseInt(compID[0]);
            int param2 = Integer.parseInt(compID[1]);
            int param3 = Integer.parseInt(compID[2]);
            if (param1 != 0) {
                game.boardFrame.dispose();
                it.remove();
            }
        }
    }
    public void end_board(String gID) {
        Iterator it = games.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String gameID = (String) pair.getKey();
            GameThread game = (GameThread) pair.getValue();
            if (gID.compareTo(gameID) == 0) {
                game.boardFrame.getBoardContainer().setEnabled(false);
                game.boardFrame.getNotificationText().setText(game.playerB.getNickname() + " has left the game");
                game.status = false;
                break;
            }
        }
        games.remove(gID);
    }
    public void close_board(String gID) {
        if (games.containsKey(gID)) {
            GameThread game = games.get(gID);
            if (game.playType == GamePlay.PVP) {
                client.endGame(game.playerB.getID(), game.map);
            }
            games.remove(gID);
        }
    }
    public void refreshGamesList() {
        Iterator it = games.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String gameID = (String) pair.getKey();
            GameThread game = (GameThread) pair.getValue();
            // ANALYZE GAME ID
            String[] compID = gameID.split("_");
            int param1 = Integer.parseInt(compID[0]);
            int param2 = Integer.parseInt(compID[1]);
            int param3 = Integer.parseInt(compID[2]);
            for (Credential credential : client.playersInfo) {
                if ((credential.getID() == param2 ||  credential.getID() == param3) && param1 == 1) {
                    game.boardFrame.dispose();
                    it.remove();
                    break;
                }
            }
        }
    }
    public void update_board(Caro newMap) {
        String gameID = newMap.getGameID();
        games.get(gameID).map = newMap;
        games.get(gameID).update_canvas(4);
    }
}

