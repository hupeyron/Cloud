package com.example.AccManager.account;

import org.springframework.web.bind.annotation.*;
import static com.googlecode.objectify.ObjectifyService.ofy;

@RestController
@RequestMapping("/employee")
public class AccountController {

    @GetMapping("/add")
    public @ResponseBody
    int addAccount(@RequestParam(value="nom", defaultValue="XXX") String nom, @RequestParam(value="prenom", defaultValue = "YYY") String prenom,
                      @RequestParam(value="num", defaultValue = "0") int num, @RequestParam(value="risk", defaultValue = "...") String risk){
        Account account = new Account(nom, prenom, num, risk);
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