package com.masivian.roulette.controllers;
import com.masivian.roulette.exception.RouletteException;
import com.masivian.roulette.model.Bet;
import com.masivian.roulette.services.BetServices;
import com.masivian.roulette.services.RouletteServices;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/roulette")
public class RouletteAPIController {
    @Autowired
    RouletteServices rouletteServices;
    @Autowired
    BetServices betServices;
	@RequestMapping(method = RequestMethod.POST)	
        public ResponseEntity<?> createNewRoulette(){
            try {
                return new ResponseEntity<>(rouletteServices.createNewRoulette(),HttpStatus.CREATED);
            } catch (RouletteException ex) {
                return new ResponseEntity<>("ERROR: "+ex.getMessage(),HttpStatus.BAD_REQUEST);            
            }
        }
        @RequestMapping(path = "/openRoulette/{id}",method = RequestMethod.PUT)	
        public ResponseEntity<?> openRoulette(@PathVariable ("id") int id){
            try {          
                rouletteServices.openRoulette(id);
                return new ResponseEntity<>("Ruleta numero "+id+" abierta",HttpStatus.ACCEPTED);
            } catch (RouletteException ex) {
                return new ResponseEntity<>("ERROR: "+ex.getMessage(),HttpStatus.BAD_REQUEST);
            }
        }
        @RequestMapping(path = "/closeRoulette/{id}",method = RequestMethod.PUT)	
        public ResponseEntity<?> closeRoulette(@PathVariable ("id") int id){
            try {          
                List<Bet> rouletteBets=rouletteServices.closeRoulette(id,betServices.listAllBets());
                betServices.updateRouletteBets(rouletteBets);
                return new ResponseEntity<>(rouletteBets,HttpStatus.ACCEPTED);
            } catch (RouletteException ex) {
                return new ResponseEntity<>("ERROR: "+ex.getMessage(),HttpStatus.BAD_REQUEST);
            }
        }
        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<?> listAllRoulettes() {
            try {
                return new ResponseEntity<>(rouletteServices.listAllRoulettes(), HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
            }
        }
}
