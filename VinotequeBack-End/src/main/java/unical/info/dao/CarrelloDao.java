package unical.info.dao;

import unical.info.model.Carrello;
import unical.info.model.Utente;

import java.util.List;

public interface CarrelloDao {

    public List<Utente> findAll();

    public Carrello findByIdUtente(String IDutente);

    public void save(Carrello carrello);

    public void delete(Carrello carrello,String IDutente);
}
