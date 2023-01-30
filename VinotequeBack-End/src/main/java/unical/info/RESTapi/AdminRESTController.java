package unical.info.RESTapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unical.info.model.Promozione;
import unical.info.model.Vino;
import unical.info.persistenza.DBManager;

@RestController
@CrossOrigin("http://localhost:4200")
public class AdminRESTController {
    @PostMapping("/newPromo")
    public void newPromo (@RequestBody Promozione promozione){
        DBManager.getInstance().getPromozioneDao().save(promozione);
    }
    @PostMapping("/newVino")
    public void newVino (@RequestBody Vino vino){
        DBManager.getInstance().getVinoDao().save(vino);
    }
}