package com.example.LoanApproval.loan;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private RestTemplate restTemplate;

    enum Reponse{
        APPROVED,
        REFUSED,
    }

    @GetMapping("/demande/{id}/{somme}")
    public @ResponseBody
    String addAccount(@PathVariable String id, @PathVariable float somme){
        String accUrl = "https://cloud-350809.ew.r.appspot.com/account/";
        String appUrl = "https://cloud-350809.ew.r.appspot.com/approval/";
        String risk = Objects.requireNonNull(this.restTemplate.getForObject(accUrl + "getbyID/{id}", Object.class, id)).toString();

        if(somme < 10000){
            if(risk == "high"){
                return "refused";
            }
            this.restTemplate.getForObject(accUrl+"edit/{nom}/{montant}", Object.class, id, somme);
            return "approved";
        }
        String rep = Objects.requireNonNull(this.restTemplate.getForObject(appUrl + "/getbyID/{nom}", Object.class, id)).toString();
        if(rep.equals(Reponse.APPROVED)){
            this.restTemplate.getForObject(accUrl+"edit/{nom}/{montant}", Object.class, id, somme);
            return "accepted";
        }else{
            return "refused";
        }
    }

}
