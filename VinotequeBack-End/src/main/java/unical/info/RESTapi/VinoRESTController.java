package unical.info.RESTapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unical.info.persistenza.DBManager;
import unical.info.model.Vino;

import java.sql.SQLException;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class VinoRESTController {

    @PostMapping("/Wine")
    public List<Vino> getWines(){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findAll();
        return vini;
    }

    @PostMapping("/WineById")
    public Vino getWine(@RequestBody String id){
        long ID = Long.parseLong(id);
        System.out.println(id+"\n"+ID);
        Vino vino = DBManager.getInstance().getVinoDao().findBYPrimaryKey(ID);
        return vino;
    }
    @PostMapping("/redWine")
    public List<Vino> getRedWines(){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findByTipologia("rosso");
        return vini;
    }

    @PostMapping("/whiteWine")
    public List<Vino> getWhiteWines(){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findByTipologia("bianco");
        return vini;
    }

    @PostMapping("/roseWine")
    public List<Vino> getRoseWines(){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findByTipologia("rosè");
        return vini;
    }

    @PostMapping("/GradazioneWine")
    public List<Vino> getWines(@RequestBody int gradazione){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findByGradazione(gradazione);
        return vini;
    }
    @PostMapping("/price")
    public List<Vino> getPriceWines(@RequestBody int min, @RequestBody int max ){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findRangePrezzo(min, max);
        return vini;
    }
    @PostMapping("/favorites")
    public List<Vino> getFavorites(@RequestBody long id) throws SQLException
    {
        List<Vino> vini_preferiti = DBManager.getInstance().getPreferitiDao().findByUtente(id);
        System.out.println(vini_preferiti);
        return vini_preferiti;
    }

}
