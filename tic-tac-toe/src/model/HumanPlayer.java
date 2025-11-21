package model;

public class HumanPlayer {
    private PlayerLevel humanPlayerLevel;

    public HumanPlayer(PlayerLevel humanPlayerLevel) {
        this.humanPlayerLevel = humanPlayerLevel;
    }

    public PlayerLevel getHumanPlayerLevel() {
        return humanPlayerLevel;
    }

    public void setHumanPlayerLevel(PlayerLevel humanPlayerLevel) {
        this.humanPlayerLevel = humanPlayerLevel;
    }
}
