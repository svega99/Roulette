package com.masivian.roulette.model;
import java.io.Serializable;
import lombok.Data;

@Data
public abstract class Bet implements Serializable{
    private int ID;
    private int amount;
    private int rouletteID;
    private int userID;
    private String state;
    public Bet(){
    }
    public Bet(int amount, int rouletteID, int userID){
        this.amount=amount;
        this.rouletteID=rouletteID;
        this.userID=userID;
        this.state="PLAYING";
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
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
