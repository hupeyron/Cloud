package com.example.demo.account;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class AccountController {

    @GetMapping("/add")
    public @ResponseBody
    Object addAccount(@RequestParam(value="nom", defaultValue="XXX") String nom, @RequestParam(value="prenom", defaultValue = "YYY") String prenom,
                      @RequestParam(value="num", defaultValue = "0") int num, @RequestParam(value="risk", defaultValue = "...") String risk){
        Account account = new Account(nom, prenom, num, risk);
        return 200;
    }

}