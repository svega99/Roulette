package com.masivian.roulette.services;
import com.masivian.roulette.exception.RouletteException;
import com.masivian.roulette.model.Bet;
import com.masivian.roulette.model.BetOnColor;
import com.masivian.roulette.model.BetOnNumber;
import com.masivian.roulette.model.Roulette;
import java.util.List;

public interface BetServices {
    public void createBetOnColor(BetOnColor betOnColor,  Roulette roulette) throws RouletteException;
    public void createBetOnNumber(BetOnNumber createBetOnNumber,  Roulette roulette) throws RouletteException;
    public List<Bet> listAllBets();
    public void updateRouletteBets(List<Bet> rouletteBets) throws RouletteException;
}
