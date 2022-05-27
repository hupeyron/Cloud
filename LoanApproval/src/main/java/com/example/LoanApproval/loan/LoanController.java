package com.example.LoanApproval.loan;

import org.springframework.web.bind.annotation.*;

import static com.googlecode.objectify.ObjectifyService.ofy;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @GetMapping("/demande/{nom}/{somme}")
    public @ResponseBody
    String addAccount(@PathVariable String nom, @PathVariable float somme){
        String reponse = "approuved";
        //récupérer risque en appelant check_account;
        if(somme < 10000){
            //appel AccManager et recup risque
            //si high alors appel appmanager
            //sinon reponse approuved et somme donnée
            return reponse;
        }
        //appel AppManager pour savoir réponse
        //si accepted compte crédité et approuved retourné

        return reponse;
    }
}
