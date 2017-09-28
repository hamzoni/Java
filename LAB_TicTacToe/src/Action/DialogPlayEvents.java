
package Action;

import Controller.Controller;
import Controller.GameData;
import Entity.Point;
import GUI.DialogPlay;
import Graphic.GameBoard;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DialogPlayEvents <T> extends Event {

    private GameData game;
    private GameBoard canvas;
    
    private int turn;
    private String opponent;
    
    private DialogPlay gui;
    private MouseListener ms;
    
    public DialogPlayEvents(Controller c, T gui) {
        super(c);
        this.gui = (DialogPlay) gui;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public void setGame(GameData game) {
        this.game = game;
        this.canvas = new GameBoard(game);
        
        updateCanvas();
        setEventListeners();
    }
    
    protected void setEventListeners() {
        ms = new MouseAdapter() {
            public void mousePressed(MouseEvent e) { 
                if (game.getTurn() == turn && game.isRun()) {
                    Point point = new Point(e.getX() / game.getCell(), e.getY() / game.getCell());
                    if (game.playerMove(point)) {
                        // Send new game data to opponent
                        c.playerMove(opponent, game);
                        canvas.repaint();
                    }
                }
            }
        };
        
        canvas.addMouseListener(ms);
        gui.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                c.exitGame(opponent, game);
            }
        });
    }
    
    public void setComponent() {
        setCompContents();
    }

    @Override
    protected void setCompContents() {
        gui.setTitle(c.me + " VS " + opponent);
        
        String txt = c.me + ": ";
        if (turn == GameData.TURNO) {
            txt += "O player";
        } else {
            txt += "X Player";
        }
        
        gui.getLabel_me().setText(txt);
        gui.pack();
    }
    
    public void closeGUI() {
        gui.dispose();
    }
    
    public void updateCanvas() {
        if (canvas != null) gui.getBoard().remove(canvas);
        gui.getBoard().setViewportView(canvas);
    }

    public String getOpponent() {
        return opponent;
    }

    public GameData getGame() {
        return game;
    }

    public GameBoard getCanvas() {
        return canvas;
    }

    public int getTurn() {
        return turn;
    }

    public DialogPlay getGui() {
        return gui;
    }
    
}
