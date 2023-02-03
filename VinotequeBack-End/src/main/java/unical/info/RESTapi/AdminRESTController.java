package unical.info.RESTapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unical.info.model.Promozione;
import unical.info.model.Recensione;
import unical.info.model.Utente;
import unical.info.model.Vino;
import unical.info.persistenza.DBManager;



@RestController
@CrossOrigin("http://localhost:4200")
public class AdminRESTController {
    @PostMapping("/newPromo")
    public boolean newPromo (@RequestBody Promozione promozione){
       return DBManager.getInstance().getPromozioneDao().save(promozione);
    }
    @PostMapping("/newVino")
    public boolean newVino (@RequestBody Vino vino){
       return DBManager.getInstance().getVinoDao().save(vino);
    }
    @PostMapping("/deleteUtente")
    public boolean deleteUtente(@RequestBody Utente utente){
      return   DBManager.getInstance().getUtenteDao().delete(utente);
    }
    @PostMapping("/deleteRecensione")
    public boolean deleteRecensione(@RequestBody Recensione recensione) {
        return DBManager.getInstance().getRecensioneDao().delete(recensione);
    }
    @PostMapping("/deleteVino")
    public boolean deleteVino(@RequestBody Vino vino){
      return  DBManager.getInstance().getVinoDao().delete(vino);
    }
}
