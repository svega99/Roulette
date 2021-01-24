package com.masivian.roulette.services;
import com.masivian.roulette.model.Bet;
import com.masivian.roulette.model.Roulette;
import java.util.List;

public interface RouletteServices {
    public int createNewRoulette();
    public void openRoulette(int id);
    public List<Bet> closeRoulette(int id);
    public List<Roulette> listAllRoulettes();
}
