package unical.info.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("http://localhost:4200")
public class Authentication {
    @GetMapping("/checkAuth")
    public Boolean isAuth(HttpServletRequest req, String jsessionid) {
        System.out.println(jsessionid);
        HttpSession session = (HttpSession) req.getServletContext().getAttribute(jsessionid);
        if (session != null) {
            return true;
        }else {
            return false;
        }
    }
}
