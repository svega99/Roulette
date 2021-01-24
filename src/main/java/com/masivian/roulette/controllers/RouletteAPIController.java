package com.masivian.roulette.controllers;
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
@RequestMapping(value = "/roulette")
public class RouletteAPIController {
    @Autowired
    RouletteServices rouletteServices;
	@RequestMapping(method = RequestMethod.POST)	
        public ResponseEntity<?> createNewRoulette(){
            try {
                return new ResponseEntity<>(rouletteServices.createNewRoulette(),HttpStatus.CREATED);
            } catch (Exception ex) {
                return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
            }
        }
        @RequestMapping(path = "/openRoulette/{id}",method = RequestMethod.PUT)	
        public ResponseEntity<?> openRoulette(@PathVariable ("id") int id){
            try {          
                rouletteServices.openRoulette(id);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } catch (Exception ex) {
                return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
            }
        }
        @RequestMapping(path = "/closeRoulette/{id}",method = RequestMethod.PUT)	
        public ResponseEntity<?> closeRoulette(@PathVariable ("id") int id){
            try {          
                
                return new ResponseEntity<>(rouletteServices.closeRoulette(id),HttpStatus.ACCEPTED);
            } catch (Exception ex) {
                return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
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
