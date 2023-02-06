package unical.info.RESTapi;

import org.springframework.web.bind.annotation.*;
import unical.info.persistenza.DBManager;
import unical.info.model.Vino;

import java.sql.SQLException;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public List<Vino> getPriceWines(@RequestBody int max ){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findMaxPrezzo(max);
        return vini;
    }
    @PostMapping("/favorites")
    public List<Vino> getFavorites(@RequestBody long id) throws SQLException {
        List<Vino> vini_preferiti = DBManager.getInstance().getPreferitiDao().findByUtente(id);
        return vini_preferiti;
    }

    @PostMapping("/favoritesID")
    public List<Integer> getFavoritesID(@RequestBody long id) throws SQLException {
        List<Integer> vini_preferiti = DBManager.getInstance().getPreferitiDao().findByUtenteLong(id);
        return vini_preferiti;
    }

    @GetMapping("/randomWine")
    public List<Vino> getRandomWine(){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findRandomWine();
        return vini;
    }

    @PostMapping("/priceRosso")
    public List<Vino> getPriceWinesRed(@RequestBody int max ){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findMaxPrezzoRosso(max);
        return vini;
    }
    @PostMapping("/priceBianco")
    public List<Vino> getPriceWinesWhite(@RequestBody int max ){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findMaxPrezzoBianco(max);
        return vini;
    }
    @PostMapping("/priceRosè")
    public List<Vino> getPriceWinesRosè(@RequestBody int max ){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findMaxPrezzoRose(max);
        return vini;
    }
    @PostMapping("/GradazioneWineRosso")
    public List<Vino> getWinesRed(@RequestBody int gradazione){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findByGradazioneRosso(gradazione);
        return vini;
    }
    @PostMapping("/GradazioneWineBianco")
    public List<Vino> getWinesWhite(@RequestBody int gradazione){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findByGradazioneBianco(gradazione);
        return vini;
    }
    @PostMapping("/GradazioneWineRosè")
    public List<Vino> getWinesRose(@RequestBody int gradazione){
        List<Vino> vini = DBManager.getInstance().getVinoDao().findByGradazioneRose(gradazione);
        return vini;
    }

    @GetMapping("/WineByName")
    public Vino getWinesByName(String name){
        Vino vino = DBManager.getInstance().getVinoDao().findByNome(name);
        return vino;
    }


}
