package com.masivian.roulette.repositories;

import com.masivian.roulette.exception.RouletteException;
import com.masivian.roulette.model.Bet;
import java.util.List;

public interface BetRepository {
    public void createOrUpdateBet(Bet bet) throws RouletteException;
    public List<Bet> listAllBets();
    public int getNumberOfBets();
}
