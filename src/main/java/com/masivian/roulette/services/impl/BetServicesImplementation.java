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
public class BetServicesImplementation implements BetServices{
    @Autowired
    BetRepository betRepository;
    @Override
    public void createBetOnColor(BetOnColor betOnColor, Roulette roulette) throws RouletteException{
        if (isOpen(roulette) && isAmountInRange(betOnColor.getAmount()) && (betOnColor.getColor().equals("BLACK") || betOnColor.getColor().equals("RED"))){
            setVariables(betOnColor);
            betRepository.createOrUpdateBet(betOnColor);
        }else{
            throw new RouletteException("Bet not valid");
        }
    }
    @Override
    public void createBetOnNumber(BetOnNumber betOnNumber, Roulette roulette) throws RouletteException{
        if(isOpen(roulette) && isAmountInRange(betOnNumber.getAmount()) && (betOnNumber.getNumber()>=0 && betOnNumber.getNumber()<=36)){
            setVariables(betOnNumber);
            betRepository.createOrUpdateBet(betOnNumber);
        }else{
            throw new RouletteException("Bet not valid");
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
    private boolean isAmountInRange(int amount){
        return amount<=10000 && amount>0;
    }
    private boolean isOpen(Roulette roulette)throws RouletteException{
        try {
            String state = roulette.getState();
            return state.equals("OPEN");
        }catch(NullPointerException ex){
            throw new RouletteException("Roulette does not exist");
        }
    }
    private void setVariables(Bet bet) {
        int newID=betRepository.getNumberOfBets()+1;
        bet.setID(newID);
        bet.setState("PLAYING");
    }
}
