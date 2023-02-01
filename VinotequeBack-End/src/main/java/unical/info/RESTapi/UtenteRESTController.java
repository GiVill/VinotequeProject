package unical.info.RESTapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unical.info.model.Carrello;
import unical.info.model.Ordine;
import unical.info.model.Preferiti;
import unical.info.model.Utente;
import unical.info.persistenza.DBManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin("http://localhost:4200")
public class UtenteRESTController {

    @PostMapping("/ordineUtente")
    public List<Ordine> ordiniUtente(@RequestBody Utente utente){
        List<Ordine> ordini = new ArrayList<>();
        ordini = DBManager.getInstance().getOrdineDao().findByUtente(utente.getId());
        return ordini;
    }
    @PostMapping("/aggiornaUtente")
    public void aggiornaUtente(@RequestBody Utente utente){
        DBManager.getInstance().getUtenteDao().aggiornaUtente(utente);
    }
    @PostMapping("/cambioPassword")
    public void cambioPassword(@RequestBody Utente utente, String password){
        DBManager.getInstance().getUtenteDao().CambioPassword(utente, password);
    }

    @PostMapping("/addFavorite")
    public void aggiungiPreferito(@RequestBody Preferiti preferito) throws SQLException {
        DBManager.getInstance().getPreferitiDao().save(preferito);
    }
    @PostMapping("/aggiornaCarrello")
    public void aggiornaCarrello(@RequestBody Utente utente, String carrello){
        DBManager.getInstance().getUtenteDao().CambioCarrello(utente.getId(), carrello);
    }
}
