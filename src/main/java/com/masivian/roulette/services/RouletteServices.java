package com.masivian.roulette.services;
import com.masivian.roulette.exception.RouletteException;
import com.masivian.roulette.model.Bet;
import com.masivian.roulette.model.Roulette;
import java.util.List;

public interface RouletteServices {
    public int createNewRoulette() throws RouletteException;
    public void openRoulette(int id) throws RouletteException;
    public List<Bet> closeRoulette(int id, List<Bet> bets) throws RouletteException;
    public Roulette getRouletteByID(int id )throws RouletteException;
    public List<Roulette> listAllRoulettes();
}
