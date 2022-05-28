package com.example.CheckAccount.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/check")
public class CheckAccountController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/getRiskByNom/{nom}")
    public @ResponseBody
    Object getRiskByID(@PathVariable String nom){
        try{
            String url = "https://acoustic-skein-351114.nw.r.appspot.com/account/getRiskByName/{nom}";
            return this.restTemplate.getForObject(url, Object.class, nom);
        } catch (Exception e){
            throw new RuntimeException("Erreur lors de la recherche du risk");
        }
    }

    @GetMapping("/test")
    public @ResponseBody
    int test(){
        return 200;
    }
}
