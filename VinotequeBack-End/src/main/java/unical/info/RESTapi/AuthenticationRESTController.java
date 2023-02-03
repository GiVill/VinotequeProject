package unical.info.RESTapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import unical.info.model.Carrello;
import unical.info.persistenza.DBManager;
import unical.info.model.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin("http://localhost:4200")
public class AuthenticationRESTController{
    @PostMapping ("/addCart")
    public boolean addCart(@RequestBody Carrello carrello) throws JsonProcessingException {
        JSONObject carrelloJson = new JSONObject(carrello);
        String jsonString = carrelloJson.toString();
        DBManager.getInstance().getUtenteDao().CambioCarrello(carrello.getIdUtente(),jsonString);
        return true;
    }

    @GetMapping ("/logout")
    public boolean logout(String jsessionid, HttpServletRequest req){
        if(jsessionid != null){
            HttpSession session = (HttpSession) req.getServletContext().getAttribute(jsessionid);
            if(session == null){
                return true;
            }
            session.removeAttribute("user");
            session.invalidate();
            return true;
        }
        return false;
    }
}
