package com.example.AccManager.account;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

import static com.googlecode.objectify.ObjectifyService.ofy;

@RestController
@RequestMapping("/employee")
public class AccountController {

    @GetMapping("/add/{nom}")
    public @ResponseBody
    int addAccount(@PathVariable String nom, @RequestParam(value="prenom", defaultValue = "PRENOM") String prenom,
                      @RequestParam(value="num", defaultValue = "0") int num, @RequestParam(value="risk", defaultValue = "...") String risk){
        Random rand = new Random(); //instance of random class
        int upperbound = 9999999;
        //generate random values from 0-9999998
        int int_random = rand.nextInt(upperbound);

        String id = Integer.toString(int_random);
        Account account = new Account(id, nom, prenom, num, risk);
        try{
            ofy().save().entity(account).now();
        } catch (Exception e){
            throw new RuntimeException("Le compte n'a pas pu être ajouté");
        }

        return 200;
    }

    @GetMapping("/test")
    public @ResponseBody
    int addAccount(){
        return 200;
    }

}