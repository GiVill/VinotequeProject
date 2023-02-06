package unical.info.RESTapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import unical.info.model.Carrello;
import unical.info.model.Ordine;
import unical.info.model.Preferiti;
import unical.info.model.Utente;
import unical.info.persistenza.DBManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public boolean cambioPassword(@RequestBody String data){
        String pattern = "(\\d+)\\s\\/\\s(.+)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(data);
        if (matcher.find()) {
            Long id = Long.valueOf(matcher.group(1));
            String pass = matcher.group(2);
            return DBManager.getInstance().getUtenteDao().CambioPassword(id, pass);
        }
        return false;
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
