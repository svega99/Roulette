package com.masivian.roulette.services.impl;
import com.masivian.roulette.exception.RouletteException;
import com.masivian.roulette.model.Bet;
import com.masivian.roulette.model.BetOnColor;
import com.masivian.roulette.model.BetOnNumber;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.repositories.BetRepository;
import com.masivian.roulette.services.BetServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetServicesImpl implements BetServices{
    @Autowired
    BetRepository betRepository;
    @Override
    public void createBetOnColor(BetOnColor betOnColor, Roulette roulette) throws RouletteException{
        int betAmount = betOnColor.getAmount();
        String betColor = betOnColor.getColor(); 
        if (validateAnyBet(roulette,betAmount) && (betColor.equals("BLACK") || betColor.equals("RED"))){
            setDefaultVariablesOfBet(betOnColor);
            betRepository.createOrUpdateBet(betOnColor);
        }else{
            throw new RouletteException("Apuesta no válida");
        }
    }
    @Override
    public void createBetOnNumber(BetOnNumber betOnNumber, Roulette roulette) throws RouletteException{
        int betAmount = betOnNumber.getAmount();
        int betNumber = betOnNumber.getNumber();
        if(validateAnyBet(roulette,betAmount) && (betNumber>=0 && betNumber<=36)){
            setDefaultVariablesOfBet(betOnNumber);
            betRepository.createOrUpdateBet(betOnNumber);
        }else{
            throw new RouletteException("Apuesta no válida");
        }
    }
    @Override
    public List<Bet> listAllBets() {
        return betRepository.listAllBets();
    }
    @Override
    public void updateRouletteBets(List<Bet> rouletteBets) throws RouletteException{
        for(Bet b :rouletteBets){
            betRepository.createOrUpdateBet(b);
        }
    }
    private boolean validateAnyBet(Roulette roulette, int amount)throws RouletteException{
        try {
            String state = roulette.getState();
            return state.equals("OPEN") && (amount<=10000 && amount>0);
        }catch(NullPointerException ex){
            throw new RouletteException("La ruleta no existe");
        }
    }
    private void setDefaultVariablesOfBet(Bet bet) {
        int newID=betRepository.getNumberOfBets()+1;
        bet.setID(newID);
        bet.setState("PLAYING");
    }
}