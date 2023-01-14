package unical.info.persistenza.dao;

import unical.info.persistenza.model.Carrello;
import unical.info.persistenza.model.Utente;

import java.util.List;

public interface CarrelloDao {

    public List<Utente> findAll();

    public Carrello findByPrimaryKey(String IDutente);

    public void saveOrUpdate(Carrello carrello,String IDutente);

    public void delete(Carrello carrello,String IDutente);
}
