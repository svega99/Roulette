package com.masivian.roulette.repositories;

import com.masivian.roulette.exception.RouletteException;
import com.masivian.roulette.model.Roulette;
import java.util.List;

public interface RouletteRepository {
    public List<Roulette> listAllRoulettes();
    public void createOrUpdateRoulette(Roulette roulette) throws RouletteException;
    public Roulette getRouletteByID(int id )throws RouletteException;
    public int getNumberOfRoulettes();
}
