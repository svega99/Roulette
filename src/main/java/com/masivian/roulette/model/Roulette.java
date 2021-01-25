package com.masivian.roulette.model;
import java.io.Serializable;
import lombok.Data;

@Data
public class Roulette implements Serializable{
    private int ID;
    private String state;
    private int winningNumber;
    private String winningColor;
    public Roulette(){
        this.state="CREATED";
        this.winningColor="";
        this.winningNumber=-1;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    
}
