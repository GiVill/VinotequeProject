package unical.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import unical.info.model.Cantina;
import unical.info.model.Vino;
import unical.info.persistenza.DBManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller()
public class SerivizioCantine {

    @GetMapping("/cantine")
    public String ristoranti(Model model, HttpServletRequest req) {
        String id = req.getParameter("id");
        Cantina cantina = DBManager.getInstance().getCantinaDao().findByPrimaryKey(Long.parseLong(id));

        List<Vino> vini = DBManager.getInstance().getVinoDao().findByCantina(Long.parseLong(id));


        model.addAttribute("cantina", cantina);
        model.addAttribute("vini", vini);
        return "cantina.html";

    }
}
