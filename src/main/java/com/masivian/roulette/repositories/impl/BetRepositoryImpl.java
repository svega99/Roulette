package com.masivian.roulette.repositories.impl;
import com.masivian.roulette.exception.RouletteException;
import com.masivian.roulette.model.Bet;
import com.masivian.roulette.repositories.BetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BetRepositoryImpl implements BetRepository{
    @Autowired
    private RedisTemplate redisTemplate;
    private static final String KEY="BETS";
    @Override
    public void createOrUpdateBet(Bet bet) throws RouletteException {
        try {
             redisTemplate.opsForHash().put(KEY,bet.getID(),bet);
        }
        catch(Exception e){
            throw new RouletteException("La apuesta no pudo ser creada o actualizada");
        }
    }
    @Override
    public List<Bet> listAllBets() {
        List<Bet> bets = redisTemplate.opsForHash().values(KEY);
        return bets;
    }
    @Override
    public int getNumberOfBets() {
        return redisTemplate.opsForHash().values(KEY).size();
    }
}
