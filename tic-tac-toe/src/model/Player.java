package model;

public class Player {
    private long id;
    private String name;
    private String emailId;
    private String playerId;
    private String country;
    private PlayerType playerType;
    private Symbol symbol;

    public Player(long id, String name, String emailId, String playerId, String country, PlayerType playerType, Symbol symbol) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.playerId = playerId;
        this.country = country;
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
