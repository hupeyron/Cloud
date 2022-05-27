package com.example.CheckAccount.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/check")
public class CheckAccountController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getRiskByID/{id}")
    public @ResponseBody
    Object getRiskByID(@PathVariable String id){
        try{
            String url = "https://cloud-350809.ew.r.appspot.com/account/getbyID/{id}";
            return this.restTemplate.getForObject(url, Object.class, id);
        } catch (Exception e){
            throw new RuntimeException("Erreur lors de la recherche du risk");
        }
    }
}