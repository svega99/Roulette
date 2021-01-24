package com.masivian.roulette.services;
import com.masivian.roulette.model.BetOnColor;
import com.masivian.roulette.model.BetOnNumber;

public interface BetServices {
    public BetOnColor createBetOnColor(BetOnColor betOnColor);
    public BetOnNumber createBetOnNumber(BetOnNumber createBetOnNumber);
}
