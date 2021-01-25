package com.masivian.roulette.model;
import java.io.Serializable;
import lombok.Data;

@Data
public class BetOnColor extends Bet implements Serializable{
    private String color;
    public BetOnColor(){
        super();
    }
    public BetOnColor(int amount, int rouletteID, int userID, String color){
        super(amount,rouletteID,userID);
        this.color=color;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
