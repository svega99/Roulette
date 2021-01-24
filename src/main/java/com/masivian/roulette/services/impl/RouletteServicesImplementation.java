package com.masivian.roulette.services.impl;
import com.masivian.roulette.model.Bet;
import com.masivian.roulette.model.Roulette;
import org.springframework.stereotype.Service;
import com.masivian.roulette.services.RouletteServices;
import java.util.List;

@Service("rouletteServicesImplementation")
public class RouletteServicesImplementation implements RouletteServices{
    @Override
    public int createNewRoulette() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void openRoulette(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Bet> closeRoulette(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Roulette> listAllRoulettes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
