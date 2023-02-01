package unical.info.RESTapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unical.info.persistenza.DBManager;
import unical.info.model.Recensione;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class RecensioniRESTController {


    @PostMapping("/Review")
    public List<Recensione> getReviewsWine(@RequestBody long idVino){
        List<Recensione> recensioni = DBManager.getInstance().getRecensioneDao().findByVino(idVino);
        return recensioni;
    }
    @PostMapping("/saveReview")
    public void saveReview(@RequestBody Recensione recensione){
        DBManager.getInstance().getRecensioneDao().save(recensione);
    }
}
