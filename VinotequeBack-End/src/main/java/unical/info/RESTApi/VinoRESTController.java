package unical.info.RESTApi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unical.info.persistenza.DBManager;
import unical.info.persistenza.model.Utente;
import unical.info.persistenza.model.Vino;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class VinoRESTController {

    @PostMapping("/Wine")
    public List<Vino> register(){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findAll();
        return vini;
    }}
