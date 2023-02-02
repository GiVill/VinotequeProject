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
    public boolean newOrdine (@RequestBody Ordine ordine){
         return DBManager.getInstance().getOrdineDao().save(ordine);
    }
    @PostMapping("/findPromo")
    public int findPromo(@RequestBody String descrizone){
        int promozione = DBManager.getInstance().getPromozioneDao().findByDescrizione(descrizone).getSconto_prezzo();
        return promozione;
    }


}
