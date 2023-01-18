package unical.info.RESTApi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unical.info.persistenza.DBManager;
import unical.info.persistenza.model.Recensione;
import unical.info.persistenza.model.Vino;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class RecensioniRESTController {


    @PostMapping("/Review")
    public List<Recensione> getReviewsWine(@RequestBody long idVino){
        System.out.println(idVino);
        List<Recensione> recensioni = DBManager.getInstance().getRecensioneDao().findByVino(idVino);
        return recensioni;
    }
}
