package unical.info.RESTapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unical.info.model.Ordine;
import unical.info.model.Promozione;
import unical.info.model.Utente;
import unical.info.persistenza.DBManager;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class OrdineRESTController {
    @PostMapping("/newOrdine")
    public void newOrdine (@RequestBody Ordine ordine){
        DBManager.getInstance().getOrdineDao().save(ordine);
    }
    @PostMapping("/findPromo")
    public Promozione findPromo(@RequestBody String descrizone){
        //int promozione = DBManager.getInstance().getPromozioneDao().findByDescrizione(descrizone).getSconto_prezzo();
        Promozione promozione = DBManager.getInstance().getPromozioneDao().findByDescrizione(descrizone);
        return promozione;
    }


}
