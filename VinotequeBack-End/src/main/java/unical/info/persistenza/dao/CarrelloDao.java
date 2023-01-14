package unical.info.persistenza.dao;

import unical.info.persistenza.model.Carrello;
import unical.info.persistenza.model.Utente;

import java.util.List;

public interface CarrelloDao {

    public List<Utente> findAll();

    public Carrello findByIdUtente(Long IDutente);

    public void save(Carrello carrello);

    public void delete(Carrello carrello,String IDutente);
}
