
package Networking;

import java.io.Serializable;
import java.util.Date;

public class Credential implements Serializable {
    private int ID;
    private String nickname;
    private int chosenTurn;
    private Date timeJoin;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getTimeJoin() {
        return timeJoin;
    }

    public void setTimeJoin(Date timeJoin) {
        this.timeJoin = timeJoin;
    }

    public int getChosenTurn() {
        return chosenTurn;
    }

    public void setChosenTurn(int chosenTurn) {
        this.chosenTurn = chosenTurn;
    }
}
