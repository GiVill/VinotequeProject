package unical.info.RESTapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
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
    public boolean aggiornaUtente(@RequestBody Utente utente){
       return DBManager.getInstance().getUtenteDao().aggiornaUtente(utente);
    }
    @PostMapping("/cambioPassword")
    public boolean cambioPassword(@RequestBody Utente utente, String password){
       return DBManager.getInstance().getUtenteDao().CambioPassword(utente, password);
    }

    @PostMapping("/addFavorite")
    public boolean aggiungiPreferito(@RequestBody Preferiti preferito) throws SQLException {
       return  DBManager.getInstance().getPreferitiDao().save(preferito);
    }


    @PostMapping("/delFavorite")
    public boolean rimuoviPreferito(@RequestBody Preferiti preferito) throws SQLException {
        return DBManager.getInstance().getPreferitiDao().delete(preferito);
    }
    @PostMapping ("/addCart")
    public boolean addCart(@RequestBody Carrello carrello){
        JSONObject carrelloJson = new JSONObject(carrello);
        String jsonString = carrelloJson.toString();
        /*
        ObjectMapper objectMapper = new ObjectMapper();
        Carrello obj = objectMapper.readValue(jeson,Carrello.class);
         */
        DBManager.getInstance().getUtenteDao().CambioCarrello(carrello.getIdUtente(),jsonString);
        return true;
    }
}
