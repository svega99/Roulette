package com.masivian.roulette.model;

public class BetOnColor extends Bet{
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
