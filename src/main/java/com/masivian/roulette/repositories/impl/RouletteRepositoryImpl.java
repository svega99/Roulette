package com.masivian.roulette.repositories.impl;
import com.masivian.roulette.exception.RouletteException;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.repositories.RouletteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RouletteRepositoryImpl implements RouletteRepository{
    @Autowired
    private RedisTemplate redisTemplate;
    private static final String KEY="ROULETTE";
    @Override
    public List<Roulette> listAllRoulettes() {
        List<Roulette> roulettes = redisTemplate.opsForHash().values(KEY);
        return roulettes;
    }
    @Override
    public void createOrUpdateRoulette(Roulette roulette) throws RouletteException{
        try {
             redisTemplate.opsForHash().put(KEY,roulette.getID(),roulette);
        }
        catch(Exception e){
            throw new RouletteException("La ruleta no pudo ser creda o actualizada");
        }
    }
    @Override
    public Roulette getRouletteByID(int id) throws RouletteException {
        Roulette rouelette = (Roulette)redisTemplate.opsForHash().get(KEY,id);
        return rouelette;
    }
    @Override
    public int getNumberOfRoulettes() {
        return redisTemplate.opsForHash().values(KEY).size();
    }
}
