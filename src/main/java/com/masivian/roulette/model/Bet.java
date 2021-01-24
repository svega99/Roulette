package com.masivian.roulette.model;

public abstract class Bet {
    private int ID;
    private int amount;
    private int rouletteID;
    private int userID;
    public Bet(){
    }
    public Bet(int amount, int rouletteID, int userID){
        this.amount=amount;
        this.rouletteID=rouletteID;
        this.userID=userID;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getRouletteID() {
        return rouletteID;
    }
    public void setRouletteID(int rouletteID) {
        this.rouletteID = rouletteID;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
}
