package com.masivian.roulette.services.impl;
import com.masivian.roulette.model.BetOnColor;
import com.masivian.roulette.model.BetOnNumber;
import com.masivian.roulette.services.BetServices;
import org.springframework.stereotype.Service;

@Service("betServicesImplementation")
public class BetServicesImplementation implements BetServices{
    @Override
    public BetOnColor createBetOnColor(BetOnColor betOnColor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public BetOnNumber createBetOnNumber(BetOnNumber createBetOnNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
