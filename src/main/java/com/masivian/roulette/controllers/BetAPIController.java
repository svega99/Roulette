package com.masivian.roulette.controllers;
import com.masivian.roulette.model.BetOnColor;
import com.masivian.roulette.model.BetOnNumber;
import com.masivian.roulette.services.BetServices;
import com.masivian.roulette.services.RouletteServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.masivian.roulette.model.Roulette;

@RestController
@RequestMapping(value = "/bet")
public class BetAPIController {
    @Autowired
    BetServices betServices;
    @Autowired
    RouletteServices rouletteServices;
        @RequestMapping(path = "/createOnColor",method = RequestMethod.POST)	
        public ResponseEntity<?> createBetOnColor(@RequestBody BetOnColor betOnColor){
            try {
                Roulette roulette = rouletteServices.getRouletteByID(betOnColor.getRouletteID());
                betServices.createBetOnColor(betOnColor,roulette);
                return new ResponseEntity<>("Bet Created",HttpStatus.CREATED);
            } catch (Exception ex) {
                return new ResponseEntity<>("ERROR: "+ex.getMessage(),HttpStatus.FORBIDDEN);            
            }
        }
        @RequestMapping(path = "/createOnNumber",method = RequestMethod.POST)	
        public ResponseEntity<?> createBetOnNumber(@RequestBody BetOnNumber betOnNumber){
            try {
                Roulette roulette = rouletteServices.getRouletteByID(betOnNumber.getRouletteID());
                betServices.createBetOnNumber(betOnNumber,roulette);
                return new ResponseEntity<>("Bet Created",HttpStatus.CREATED);
            } catch (Exception ex) {
                return new ResponseEntity<>("ERROR: "+ex.getMessage(),HttpStatus.FORBIDDEN);            
            }
        }
        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<?> listAllBets() {
            try {
                return new ResponseEntity<>(betServices.listAllBets(), HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>("ERROR: "+e.getMessage(),HttpStatus.NOT_FOUND);
            }
        }
}