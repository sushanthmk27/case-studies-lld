package model;

public class BotPlayerLevel {
    private PlayerLevel botPlayerLevel;

    public BotPlayerLevel(PlayerLevel botPlayerLevel) {
        this.botPlayerLevel = botPlayerLevel;
    }

    public PlayerLevel getBotPlayerLevel() {
        return botPlayerLevel;
    }

    public void setBotPlayerLevel(PlayerLevel botPlayerLevel) {
        this.botPlayerLevel = botPlayerLevel;
    }
}
