package unical.info.RESTapi;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unical.info.model.Richieste;
import unical.info.persistenza.DBManager;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class RichiesteRESTController {
    @PostMapping("/Accetta")
    public boolean promuovi(@RequestBody Richieste richieste){
        return DBManager.getInstance().getRichiesteDao().PromuoviASommelier(richieste);

    }

    @PostMapping("/Rifiuta")
    public boolean rifiuta(@RequestBody Richieste richieste){
        return DBManager.getInstance().getRichiesteDao().delete(richieste);
    }

    @PostMapping("/newRichiesta")
    public boolean newRichiesta(@RequestBody Richieste richieste){
        return  DBManager.getInstance().getRichiesteDao().save(richieste);
    }
    @PostMapping("/request")
    public List<Richieste> getRichieste(){
        List<Richieste> richieste = DBManager.getInstance().getRichiesteDao().findAll();
        return richieste;
    }

}
