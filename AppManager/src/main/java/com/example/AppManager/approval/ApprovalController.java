package com.example.AppManager.approval;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

import static com.googlecode.objectify.ObjectifyService.ofy;

@RestController
@RequestMapping("/approval")
public class ApprovalController {

    @GetMapping("/getAll")
    public @ResponseBody
    Iterable<Approval> getAll(){
        Iterable<Approval> approvals;
        try{
            approvals = ofy().load().type(Approval.class);
        } catch (Exception e){
            throw new RuntimeException("Erreur d'affichages des réponses");
        }

        return approvals;
    }

    @GetMapping("/getbyID/{id}")
    public @ResponseBody
    Approval getByID(@PathVariable String id){
        Approval approval;
        try{
            approval = ofy().load().type(Approval.class).id(id).now();
            if (approval == null){
                throw new RuntimeException("L'id saisi n'est pas correct");
            }
        } catch (Exception e){
            throw new RuntimeException("Erreur lors de la recherche du compte");
        }

        return approval;
    }

    @GetMapping("/add/{nom}")
    public @ResponseBody
    int addAccount(@PathVariable String nom, @RequestParam(value="reponse", defaultValue = "ACCEPTED") Approval.Reponse reponse){
        String id = getRandomInt();
        Approval approval = new Approval(id, nom, reponse);
        try{
            ofy().save().entity(approval).now();
        } catch (Exception e){
            throw new RuntimeException("La reponse n'a pas pu être ajouté");
        }
        return 200;
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
