package unical.info.RESTapi;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unical.info.model.Richieste;
import unical.info.persistenza.DBManager;

@RestController
@CrossOrigin("http://localhost:4200")
public class RichiesteRESTController {
    @PostMapping("/Accetta")
    public void promuovi(@RequestBody Richieste richieste){
        DBManager.getInstance().getRichiesteDao().PromuoviASommelier(richieste);
    }

    @PostMapping("/Rifiuta")
    public void rifiuta(@RequestBody Richieste richieste){
        DBManager.getInstance().getRichiesteDao().delete(richieste);
    }

    @PostMapping("/newRichiesta")
    public boolean newRichiesta(@RequestBody Richieste richieste){
        if (DBManager.getInstance().getRichiesteDao().save(richieste))
            return true;
        else{
            return false;
        }
    }
}
