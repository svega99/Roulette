package com.masivian.roulette.model;

public class BetOnNumber extends Bet{
    private int number;
    public BetOnNumber(){
        super();
    }
    public BetOnNumber(int amount, int rouletteID, int userID, int number){
        super(amount,rouletteID,userID);
        this.number=number;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
