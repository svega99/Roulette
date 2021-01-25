package com.masivian.roulette.services.impl;
import com.masivian.roulette.exception.RouletteException;
import com.masivian.roulette.model.Bet;
import com.masivian.roulette.model.BetOnColor;
import com.masivian.roulette.model.BetOnNumber;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.repositories.RouletteRepository;
import org.springframework.stereotype.Service;
import com.masivian.roulette.services.RouletteServices;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RouletteServicesImplementation implements RouletteServices{
    @Autowired
    RouletteRepository rouletteRepository;
    @Override
    public int createNewRoulette() throws RouletteException{
        int newID = getNumberOfRoulettes()+1;
        Roulette newRoulette = new Roulette(); 
        newRoulette.setID(newID);
        rouletteRepository.createOrUpdateRoulette(newRoulette);
        return newRoulette.getID();
    }
    @Override
    public void openRoulette(int id) throws RouletteException{
        try{
             Roulette roulette = getRouletteByID(id);
             if (roulette.getState().equals("OPEN")){
                 throw new RouletteException("Roulette is already open");
             }else{
                 roulette.setState("OPEN");
                 roulette.setWinningColor("");
                 roulette.setWinningNumber(-1);
             }
             rouletteRepository.createOrUpdateRoulette(roulette);
        }catch(NullPointerException ex){
            throw new RouletteException("Roulette not found");
        }catch(RouletteException re){
            throw new RouletteException("Roulette is already open");
        }
        
    }
    @Override
    public List<Bet> closeRoulette(int id, List<Bet> bets) throws RouletteException{
        try{
            List<Bet> rouletteBets = new ArrayList<>();
            Roulette roulette = getRouletteByID(id);
            if (!roulette.getState().equals("OPEN")){
                throw new RouletteException("Roulette is not open");
            }else{
                setWinner(roulette);
                rouletteBets = setRouletteBetsResults(bets,roulette);
            }
            rouletteRepository.createOrUpdateRoulette(roulette);
            return rouletteBets;
        }catch(NullPointerException ex){
            throw new RouletteException("Roulette not found");
        }catch(RouletteException re){
            throw new RouletteException("Roulette is not open");
        }
    }
    @Override
    public List<Roulette> listAllRoulettes() {
        return rouletteRepository.listAllRoulettes();
    }

    @Override
    public Roulette getRouletteByID(int id) throws RouletteException {
        Roulette roulette=rouletteRepository.getRouletteByID(id);
        return roulette;
    }
    @Override
    public int getNumberOfRoulettes() {
        return rouletteRepository.getNumberOfRoulettes();
    }
    private void setWinner(Roulette roulette) {
        int winnerNumber=(int)(Math.random() * (38));
        String winnerColor;
        if (winnerNumber%2==0){
            winnerColor="RED";
        }else{
            winnerColor="BLACK";
        }
        roulette.setWinningColor(winnerColor);
        roulette.setWinningNumber(winnerNumber);
        roulette.setState("CLOSED");
    }
    private List<Bet> setRouletteBetsResults(List<Bet> bets, Roulette roulette){
        List<Bet> rouletteBets = new ArrayList<>();
        for (Bet b:bets){
            if(b.getRouletteID()==roulette.getID() && b.getState().equals("PLAYING")){ 
                if(b instanceof BetOnColor){
                    if(((BetOnColor) b).getColor().equals(roulette.getWinningColor())){
                        b.setState("WINNER");
                        b.setAmount((int) (b.getAmount()*1.8));
                    }
                    else{
                        b.setState("LOSER");
                        b.setAmount(0);
                    }
                }
                if(b instanceof BetOnNumber){
                    if(((BetOnNumber) b).getNumber()==roulette.getWinningNumber()){
                        b.setState("WINNER");
                        b.setAmount(b.getAmount()*5);
                    }
                    else{
                        b.setState("LOSER");
                        b.setAmount(0);
                    }
                }
                rouletteBets.add(b);
            }
        }
        return rouletteBets;
    } 
}
