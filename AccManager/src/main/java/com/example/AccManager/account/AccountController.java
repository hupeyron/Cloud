package com.example.AccManager.account;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

import static com.googlecode.objectify.ObjectifyService.ofy;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/add/{nom}")
    public @ResponseBody
    int addAccount(@PathVariable String nom, @RequestParam(value="prenom", defaultValue = "PRENOM") String prenom,
                      @RequestParam(value="num", defaultValue = "0") int num, @RequestParam(value="risk", defaultValue = "...") String risk){
        String id = getRandomInt();
        Account account = new Account(id, nom, prenom, num, risk);
        try{
            ofy().save().entity(account).now();
        } catch (Exception e){
            throw new RuntimeException("Le compte n'a pas pu être ajouté");
        }

        return 200;
    }

    @GetMapping("/delete/{id}")
    public @ResponseBody
    int deleteAccount(@PathVariable String id){
        try{
            ofy().delete().type(Account.class).id(id);
            return 200;
        } catch (Exception e){
            throw new RuntimeException("Le compte n'a pas pu être ajouté");
        }
    }

    @GetMapping("/getAll")
    public @ResponseBody
    Iterable<Account> getAll(){
        Iterable<Account> accounts;
        try{
             accounts = ofy().load().type(Account.class);
        } catch (Exception e){
            throw new RuntimeException("Erreur d'affichages des comptes");
        }

        return accounts;
    }

    @GetMapping("/getbyID/{id}")
    public @ResponseBody
    Account getByID(@PathVariable String id){
        Account account;
        try{
            account = ofy().load().type(Account.class).id(id).now();
            if (account == null){
                throw new RuntimeException("L'id saisi n'est pas correct");
            }
        } catch (Exception e){
            throw new RuntimeException("Erreur lors de la recherche du compte");
        }

        return account;
    }

    @GetMapping("/test")
    public @ResponseBody
    int addAccount(){
        return 200;
    }

    private String getRandomInt() {
        Random rand = new Random(); //instance of random class
        int upperbound = 9999999;
        //generate random values from 0-9999998
        int int_random = rand.nextInt(upperbound);

        return Integer.toString(int_random);
    }
}