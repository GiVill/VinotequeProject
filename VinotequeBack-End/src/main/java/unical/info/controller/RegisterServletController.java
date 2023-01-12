package unical.info.controller;

import org.springframework.web.bind.annotation.*;
import unical.info.DBManager;
import unical.info.model.Utente;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;


@RestController
@CrossOrigin("http://localhost:4200")
public class RegisterServletController extends HttpServlet {
    @PostMapping ("/addUser")
    public Boolean register( @RequestBody Utente newUser){
        System.out.println(newUser.toString());
        //TODO: CONTROLLO EMAIL GIA PRESENTE NEL DB
        DBManager.getInstance().getUtenteDao().saveOrUpdate(newUser);
        return true;
    }


    @PostMapping ("/login")
    public String login( @RequestBody String email, String password){
        //TODO: CERCA CREDENZIALI NEL DB E RESTITUISCE L'ID come stringa o jsessionid
        return  "ciao";
    }
}


