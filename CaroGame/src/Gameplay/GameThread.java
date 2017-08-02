
package Gameplay;

import Compute.AIBrain;
import Compute.AIControl;
import Compute.Board;
import Compute.Graphic;
import Entities.Coordinate;
import Entities.Caro;
import Entities.Player;
import Entities.Score;
import Middleware.Case;
import Middleware.Clone;
import Middleware.Moment;
import Networking.Credential;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/* ACTUAL PLAY THREAD */
class GameThread implements Runnable {
    public Board boardFrame;
    private Graphic canvas;
    public boolean status;
    public int turnA;
    public int turnB;
    private AIControl bot;
    public Credential playerA;
    public Credential playerB;
    private GamePlay gpl;
    public int playType;
    private Case match;
    public Caro map;
    
    
    public GameThread(int playType, int playerTurn, GamePlay gpl) {
        this.playType = playType;
        this.turnA = playerTurn;
        this.turnB = turnA == 0 ? 1 : 0;
        this.gpl = gpl;
    }
    @Override
    public void run() {
        status = true;
        match = new Case(map);
        bot = new AIControl();
        make_shift();
        draw_frame();
        draw_board();
        set_action();
        pve_first_move();
    }
    public void pve_first_move() {
        if (turnB == 0 && playType == GamePlay.PVE) {
            bot.setBoard(Clone.clone(map));
            Coordinate AI_move = bot.getMove();
            set_move(AI_move.x, AI_move.y);
        }
    }
    public void make_shift() {
        if (playType != GamePlay.PVP) return;
        Credential P1 = (Credential) map.getDuo().getA();
        Credential P2 = (Credential) map.getDuo().getB();
        if (turnA == P1.getChosenTurn()) {
            playerA = P1;
            playerB = P2;
        } else {
            playerA = P2;
            playerB = P1;
        }
    }
    public void draw_frame() {
        boardFrame = new Board(gpl, map.getGameID());
        if (playType == GamePlay.PVE) {
            map.players.add(new Player(1, "X", turnA != 0));
            map.players.add(new Player(2, "O", turnA != 1));
        } else if (playType == GamePlay.PVP) {
            map.players.add(new Player(1, "X", false));
            map.players.add(new Player(2, "O", false));
        } else if (playType == GamePlay.DEMO) {
             map.players.add(new Player(1, "X", false));
        }

        canvas = new Graphic();
        update_canvas(1);
    }
    public void draw_board() {
        boardFrame.setVisible(true);
        // SET DATA FOR BOARD
        if (playType == GamePlay.PVP) {
            String boardTitle = playerA.getNickname() + " vs " + playerB.getNickname() + " @ " + Moment.getTime(new Date());
            boardFrame.setTitle(boardTitle);
            boardFrame.getPlayerName_1().setText(playerA.getNickname());
            boardFrame.getPlayerName_2().setText(playerB.getNickname());
        } else if (playType == GamePlay.PVE) {
            String boardTitle = "Player vs Bot @ " + Moment.getTime(new Date());
            boardFrame.setTitle(boardTitle);
            boardFrame.getPlayerName_1().setText("Player");
            boardFrame.getPlayerName_2().setText("Bot");
        }
        JScrollPane board = boardFrame.getBoard_panel();
        board.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        board.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        canvas.setPreferredSize(new java.awt.Dimension(map.cols * map.cellsize, map.rows * map.cellsize));
        board.setViewportView(canvas);
    }
    public void update_canvas(int x) {
//        System.out.println(x);
        // UPDATE CANVAS
        canvas.map = map;
        canvas.repaint();
        
        // UPDATE HEADER
        match.check(map);
        update_header();
        if (playType != GamePlay.DEMO) {
            if (match.getStatus() != -1) {
                update_score();
            }
        }
    }
    public void update_header() {
        String announceTxt = "";
        if (match.getStatus() == 1) {
            announceTxt = playType == GamePlay.PVP ? 
                (match.getWinner() == playerA.getChosenTurn() ? playerA.getNickname() : playerB.getNickname()) :
                (match.getWinner() == turnA ? "Player" : "Bot");
            announceTxt += " - " + get_turn_string(match.getWinner()) + " win";
        } else if (match.getStatus() == 0) {
            announceTxt = "Game Drawn";
        } else if (match.getStatus() == -1) {
            if (playType == GamePlay.PVP) {
                Credential crrPlayer = playerA.getChosenTurn() == map.getTurn() ? playerA : playerB;
                announceTxt = "Player " + crrPlayer.getNickname() + " - " + (crrPlayer.getChosenTurn() == 0 ? "X" : "O") + " turn";
            } else if (playType == GamePlay.PVE) {
                announceTxt = "Player " +  (map.getTurn() == turnA ? "Player" : "Bot") + " - " + (map.getTurn() == 0 ? "X" : "O") + " turn";
            }
        }
        boardFrame.getPlayer_turn().setText(announceTxt);
    }
    public void update_score() {
        if (match.getStatus() == 1) {
            if (match.getWinner() == turnA) {
                map.players.get(turnA).getScore().win++;
                map.players.get(turnB).getScore().lose++;
            } else if (match.getWinner() == turnB) {
                map.players.get(turnB).getScore().win++;
                map.players.get(turnA).getScore().lose++;
            }
        } else if (match.getStatus() == 0) {
            map.players.get(turnA).getScore().drawn++;
            map.players.get(turnB).getScore().drawn++;
        }
        
        Score scoreA = map.players.get(turnA).getScore();
        Score scoreB = map.players.get(turnB).getScore();

        boardFrame.getScoring1().setText(scoreA.win + "/" + scoreA.drawn + "/" + scoreA.lose);
        boardFrame.getScoring2().setText(scoreB.win + "/" + scoreB.drawn + "/" + scoreB.lose);
        
        game_ending();
    }
    public void set_move(int x, int y) {
        if (x >= map.cols  || y >= map.rows || x < 0 || y < 0 || status == false) return;
        match.check(map);
        if (match.getStatus() == -1) {
            if (map.getMap()[x][y] == 0) {
                if (playType == GamePlay.PVE) {
                    map.players.get(map.getTurn()).coords.add(new Coordinate(x, y));
                    map.nextMove(x, y);
                    match.check(map);
                    if (match.getStatus() == -1) {
                        if (map.players.get(map.getTurn()).isBot()) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    bot.setBoard(Clone.clone(map));
                                    Coordinate AI_move = bot.getMove();
                                    set_move(AI_move.x, AI_move.y);
                                }
                            }).start();
                        }
                    }
                } else if (playType == GamePlay.PVP) {
                    map.players.get(map.getTurn()).coords.add(new Coordinate(x, y));
                    map.nextMove(x, y);
                    
                    Credential target = (Credential) map.getDuo().getB();
                    target = target.getChosenTurn() == map.getTurn() ? target : (Credential) map.getDuo().getA();
                    gpl.client.send(target.getID(), map);
                } else {
                    map.players.get(0).coords.add(new Coordinate(x, y));
                    map.nextMove(x, y);
                }
            }
        }
        update_canvas(2);
    }
    public void game_ending() {
        if (status == false) return;
        boolean replay = false;
        replay = gpl.window.frame_c.prompt_end_game();
        if (replay) {
            if (status == false) return;
            status = true;
            map.reset();
            update_canvas(3); 
            pve_first_move();
            
        } else {
            status = false;
            boardFrame.getBoardContainer().setEnabled(false);
            gpl.games.remove(map.getGameID());
            
            boardFrame.getNotificationText().setText("Game Over");
            if (playType == GamePlay.PVP) {
                gpl.client.endGame(playerB.getID(), map);
            }
        }
    }
    public String get_turn_string(int turn) {
        return turn == 0 ? "X" : "O";
    }
    public void set_action() {
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (playType != GamePlay.DEMO) {
                    if (map.players.get(map.getTurn()).isBot()) return;
                    if (turnA != -1 && map.getTurn() != turnA) return;
                }
                if (SwingUtilities.isLeftMouseButton(e)) {
                    set_move(e.getX() / map.cellsize, e.getY() / map.cellsize);
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    // moving the map
                };
            }
        });
    }
}