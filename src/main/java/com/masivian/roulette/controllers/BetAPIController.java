package com.masivian.roulette.controllers;
import com.masivian.roulette.model.BetOnColor;
import com.masivian.roulette.model.BetOnNumber;
import com.masivian.roulette.services.BetServices;
import com.masivian.roulette.services.RouletteServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/bet")
public class BetAPIController {
    @Autowired
    BetServices betServices;
        @RequestMapping(path = "/createOnColor",method = RequestMethod.POST)	
        public ResponseEntity<?> createBetOnColor(@RequestBody BetOnColor betOnColor){
            try {
                return new ResponseEntity<>(betServices.createBetOnColor(betOnColor),HttpStatus.CREATED);
            } catch (Exception ex) {
                return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
            }
        }
        @RequestMapping(path = "/createOnNumber",method = RequestMethod.POST)	
        public ResponseEntity<?> createBetOnNumber(@RequestBody BetOnNumber betOnNumber){
            try {
                return new ResponseEntity<>(betServices.createBetOnNumber(betOnNumber),HttpStatus.CREATED);
            } catch (Exception ex) {
                return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
            }
        }
}
