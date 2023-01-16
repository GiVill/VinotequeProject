package unical.info.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import unical.info.persistenza.model.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("http://localhost:4200")
public class Authentication {
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
}
