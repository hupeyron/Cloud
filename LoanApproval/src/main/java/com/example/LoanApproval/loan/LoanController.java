package com.example.LoanApproval.loan;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private RestTemplate restTemplate;

    enum Reponse {
        ACCEPTED,
        REFUSED,
    }

    @GetMapping("/demande/{nom}/{somme}")
    public @ResponseBody
    Reponse addAccount(@PathVariable String nom, @PathVariable float somme){
        String accUrl = "https://cloud-350809.ew.r.appspot.com/account/getRiskByName/{nom}";
        String appUrl = "https://cloud-350809.ew.r.appspot.com/approval/getbyID/";
        Object risk = this.restTemplate.getForObject(accUrl, Object.class, nom);
        risk = risk.toString();
        if(somme < 10000){
            if(risk == "high"){
                //si high alors appel appmanager lister les approval et regarder si on a un approval pour le client qui veut un crédit
            }
            //donner la somme au demandeur
            return Reponse.ACCEPTED;
        }
        //appel AppManager pour savoir réponse
        //si accepted compte crédité et approuved retourné
        return Reponse.ACCEPTED;
    }
}
