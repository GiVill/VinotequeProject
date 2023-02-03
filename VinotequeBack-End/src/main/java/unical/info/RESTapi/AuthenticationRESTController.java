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
    public void addCart(@RequestBody Carrello carrello) throws JsonProcessingException {
        JSONObject carrelloJson = new JSONObject(carrello);
        String jsonString = carrelloJson.toString();
        DBManager.getInstance().getUtenteDao().CambioCarrello(carrello.getIdUtente(),jsonString);
    }

    @GetMapping("/checkAuth")
    public Utente isAuth(HttpServletRequest req, String jsessionid) {
        System.out.println(jsessionid);
        HttpSession session = (HttpSession) req.getServletContext().getAttribute(jsessionid);
        Utente currentUser = (Utente) session.getAttribute("user");
        if (session != null) {
            return currentUser;
        }else {
            return null;
        }
    }
    @GetMapping ("/logout")
    public boolean logout(String jsessionid, HttpServletRequest req){
        if(jsessionid != null){
            HttpSession session = (HttpSession) req.getServletContext().getAttribute(jsessionid);
            if(session == null || session.getAttribute("user") == null){
                return true;
            }
            session.removeAttribute("user");
            session.invalidate();
            return true;
        }
        return false;
    }
}
